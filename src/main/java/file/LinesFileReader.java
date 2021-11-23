package file;/**
 * User: mqray
 * Date: 2021/11/21
 */

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author mqray
 * @Date 2021/11/21
 */
public abstract class LinesFileReader extends AbstractFileReader{

    private final BufferedReader bufferedReader;

    LinesFileReader(String filePath) throws FileNotFoundException {
        super(filePath);
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_LOADED)));
    }

    @Override
    public Iterable<Map<String, Object>> read() throws Exception {

        return null;
    }

    @Override
    public void close() throws IOException {
        if(bufferedReader != null){
            try{
                bufferedReader.close();
            }catch (IOException e){
                //
            }
        }
    }

    Iterable<String> readLineIterable() throws FileNotFoundException{
        ensureFileExists();
        return () -> new LineInterator(bufferedReader);
    }

    private static class LineInterator implements Iterator<String>{

        private BufferedReader bufferedReader;

        private String nextLine;

        public LineInterator(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
            this.nextLine = readLine();
        }


        @Override
        public boolean hasNext() {
            return this.nextLine != null;
        }

        @Override
        public String next() {
            String context = nextLine;
            if(nextLine!=null){
                nextLine = readLine();
            }
            return context;
        }

        private String readLine(){
            try{
                return bufferedReader.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }
}
