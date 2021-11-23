package file;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Iterables;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public class JsonLineFileReader extends LinesFileReader{

    public JsonLineFileReader(String filePath) throws FileNotFoundException {
        super(filePath);
    }

    @Override
    public Iterable<Map<String, Object>> read() throws IOException{
        return Iterables.transform(readLineIterable(), JSONObject::parseObject);
    }

}
