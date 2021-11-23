package file;

import java.io.FileNotFoundException;

/**
 * @Author mqray
 * @Date 2021/11/23
 */
public class ReaderManager {
    public static FileReader getAvroFileReader(String filePath){
        return new AvroFileReader(filePath);
    }


    public static FileReader getJsonFileReader(String filePath) throws FileNotFoundException {
        return new JsonLineFileReader(filePath);
    }

    public static FileReader getCsvFileReader(String filePath) throws FileNotFoundException {
        return new CsvLineFileReader(filePath);
    }
}
