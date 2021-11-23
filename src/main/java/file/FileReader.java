package file;

import java.io.Closeable;
import java.util.Map;

/**
 * User: mqray
 * Date: 2021/11/21
 * @author mqray
 */
public interface FileReader extends Closeable {

    /**
     * @return iterable
     * @throws Exception
     */
    Iterable<Map<String, Object>> read() throws Exception;
}
