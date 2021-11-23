package file;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public class AvroFileReader extends AbstractFileReader{

    private static final CharsetDecoder DEFAULT_DECODER = StandardCharsets.UTF_8.newDecoder()
            .onMalformedInput(CodingErrorAction.REPLACE)
            .onUnmappableCharacter(CodingErrorAction.REPLACE);

    private DatumReader<GenericDatumReader> datumReader = new GenericDatumReader<>();

    private DataFileReader<GenericRecord> reader;

    public AvroFileReader(String filePath) {
        super(filePath);
    }



    @Override
    public Iterable<Map<String, Object>> read() throws Exception {
        ensureFileExists();
        new DataFileReader<>(new File(FILE_PATH), datumReader);
        List<Schema.Field> fields = reader.getSchema().getFields();
        return Iterables.transform(
                reader, record -> {
                    Map<String, Object> results = Maps.newHashMapWithExpectedSize(fields.size());
                    for(Schema.Field field: fields){
                        String fieldName = field.name();
                        Object value = record.get(fieldName);
                        if (value instanceof ByteBuffer){
                            value = decodeString((ByteBuffer) value);
                        }
                        results.put(fieldName, value);
                    }
                    return results;
                });
    }


    private String decodeString(ByteBuffer byteBuffer){
        try{
            return DEFAULT_DECODER.decode(byteBuffer).toString();
        }catch (CharacterCodingException e){
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        if (reader!=null){
            reader.close();
        }
    }
}
