import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ReadFileByColumn {
    private Path fileName;
    private int column;

    ReadFileByColumn(int column, Path fileName) throws IOException {
        this.column = column;
        this.fileName = fileName;
    }

    public Map<Integer, String> reading() throws IOException {
        Map<Integer, String> str = new HashMap<Integer, String>();
        AtomicInteger lineNumber= new AtomicInteger(1);
        Files.lines(this.fileName).forEach(line->{
            char separator = ',';
            //int[] index = IntStream.range(0, line.length()).filter(i->line.charAt(i) == separator).toArray();
            int index[] = IntStream.range(1, line.length() - 1).filter(i -> line.charAt(i) == separator && line.charAt(i + 1) != ' ')
                        .toArray();
            if(column==0)
            {
                str.put(Integer.parseInt(line.substring(0,index[0])
                                .replace(",","").replace("\"",""))
                        ,line.substring(index[0],index[1])
                                .replace(",","").replace("\"",""));
            }else
            {
                str.put(Integer.parseInt(line.substring(0,index[0])
                                .replace(",","").replace("\"",""))
                        ,line.substring(index[this.column],index[this.column+1])
                                .replace(",","").replace("\"",""));
            }
            lineNumber.getAndIncrement();
        });
        return str;
    }
}
