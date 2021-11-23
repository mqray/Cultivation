package file;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public class CsvLineFileReader extends LinesFileReader{

    private List<String> fieldNames;

    public CsvLineFileReader(String filePath) throws FileNotFoundException {
        super(filePath);
    }

    @Override
    public Iterable<Map<String, Object>> read() throws IOException{

        Iterator<String> iterator = readLineIterable().iterator();
        String header = iterator.next();
        if(header == null){
            return Collections.emptyList();
        }
        fieldNames = getFields(header);
        return ()-> Iterators.transform(iterator, lineContext ->{
            List<String> fields = getFields(lineContext);
            return IntStream.range(0, fieldNames.size()).collect(
                    HashMap::new, (map, i) -> map.put(fieldNames.get(i), fields.get(i)), (map1, map2) ->{}
            );
        });
    }

    private List<String> getFields(String lineContext){
        return Splitter.on(",").trimResults().splitToList(lineContext);
    }

}
