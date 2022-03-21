import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class SortingFileByColumn {
    private int column;
    private Path fileName;

    SortingFileByColumn(int column, Path fileName)
    {
        this.column = column;
        this.fileName = fileName;
    }

    public Set<Map.Entry<Integer, String>> Sort() throws IOException {
        ReadFileByColumn reading = new ReadFileByColumn(column, fileName);
        Map<Integer, String> array = reading.reading();
        array.entrySet().stream()
                .sorted(Map.Entry.<Integer,String>comparingByValue()).forEach(System.out::println);
        Set<Map.Entry<Integer,String>> setArray = array.entrySet();
        return setArray;
    }
}
