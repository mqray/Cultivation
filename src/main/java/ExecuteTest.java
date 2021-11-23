import engine.Context;
import engine.Node;
import entity.TcpFlow;
import file.FileReader;
import file.ReaderManager;
import mapping.EntityMapping;
import parsing.DefaultExprParser;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @Author mqray
 * @Date 2021/11/23
 */
public class ExecuteTest {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "tcp_flow.json";
        String exp = "src_ip = '10.1.199.6' && dst_ip = '10.1.196.1' && session_state != 4 && (down_pkts > 100 || down_pkts < 300)";
        DefaultExprParser exprParser = new DefaultExprParser();
        // 获取过滤表达式
        Node node = exprParser.parse(exp);
        EntityMapping mapping = EntityMapping.getInstance();
        int i = 1;
        String path = ExecuteTest.class.getClassLoader().getResource(fileName).getPath();
        try(FileReader jsonFileReader = ReaderManager.getJsonFileReader(path)){
            Iterable<Map<String, Object>> records = jsonFileReader.read();
            for(Map<String, Object> record: records){
                // 字段映射
                TcpFlow tcpFlow = mapping.fromMap(record, TcpFlow.class);
                EntityContext<TcpFlow> tcpFlowEntityContext = new EntityContext<>(tcpFlow, mapping.getFieldMapping(TcpFlow.class));
                Object result = node.eval((Context) tcpFlowEntityContext);
                if ((Boolean) result){
                    System.out.println("[" + i++ + "]" + tcpFlow);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
