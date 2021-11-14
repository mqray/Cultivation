package fileloader;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class FileLoaderFactory {

    private static final Map<String, IFileLoader> fileLoaders = new HashMap<>();

    static {
        fileLoaders.put("json", new JsonIFileLoader());
        fileLoaders.put("avro", new AvroIFileLoader());
        fileLoaders.put("csv", new CsvIFileLoader());
    }

    public static IFileLoader createFileLoader(String fileType){
        if (StringUtils.isBlank(fileType)){
            return null;
        }
        IFileLoader fileLoader = fileLoaders.get(fileType);
        return fileLoader;
    }

}
