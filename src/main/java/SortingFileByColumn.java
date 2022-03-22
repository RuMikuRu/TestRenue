import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingFileByColumn  {
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
        Map<Integer, String> sortedArray = array.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2) -> e1,
                        LinkedHashMap::new));
        sortedArray.entrySet();
        return sortedArray.entrySet();
    }
}
