package fileloader;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataloader.TcpFlow;
import java.util.List;

public interface IFileLoader {

    /**
     * 从不同的文件中读取信息
     *
     * @param filePath
     */

    List<TcpFlow> readFileInfo(String filePath) throws JsonProcessingException;
}
