package fileloader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataloader.TcpFlow;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class JsonIFileLoader implements IFileLoader {

    static {

    }

    @Override
    public List<TcpFlow> readFileInfo(String filePath) throws JsonProcessingException {
        /**
         * 从json文件中读取tcpFlow
         * 按行读取然后解析
         */
        String tcpFlowString = reader(filePath);
        if(StringUtils.isBlank(tcpFlowString)){
            this.process(tcpFlowString);
        }
        return null;
    }

    public String reader(String filePath){
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = bufferedReader.readLine();
                while (lineTxt != null) {
                    return lineTxt;
                }
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            System.out.println("Cannot find the file specified!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file content!");
            e.printStackTrace();
        }
        return null;
    }

    public TcpFlow process(String singleTcpFlowRecord) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TcpFlow tcpFlow = objectMapper.readValue(singleTcpFlowRecord, TcpFlow.class);
        return tcpFlow;
    }


}
