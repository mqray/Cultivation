package dataloader;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class DataLoaderFactory {

    private static final Map<String, IDataLoader> dataLoaders = new HashMap<>();

    static {
        dataLoaders.put("file", new FileDataLoader());
        dataLoaders.put("kafka", new KafkaDataLoader());
        dataLoaders.put("syslog", new SyslogDataLoader());
    }

    public static IDataLoader createDataLoader(String dataSource){
        if (StringUtils.isBlank(dataSource)){
            return null;
        }
    IDataLoader dataLoader = dataLoaders.get(dataSource);
    return dataLoader;
    }
}
