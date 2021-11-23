package file;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Date: 2021/11/21
 * @author mqray
 */
 abstract class AbstractFileReader implements FileReader{

     final File FILE_LOADED;
     final String FILE_PATH;

    AbstractFileReader(String filePath) {
        this.FILE_PATH = filePath;
        this.FILE_LOADED = new File(filePath);
    }

    void ensureFileExists() throws FileNotFoundException{
        if(!this.FILE_LOADED.exists()){
            throw new FileNotFoundException("file not found "+ FILE_PATH);
        }
    }
}
