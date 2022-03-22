import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutionException;


public class Main {
    private static final HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
    public static void main(String[] args) throws IOException {
        try{
            Path file = Paths.get("src/main/resources/airports.dat");
            //String content = Files.lines(Path.of(String.valueOf(file))).sorted(Comparator.comparing(line->Integer.parseInt(line.split(",")[1])))
                 //   .collect(Collectors.joining("\n"));
            //Files.write(Paths.get("Sorted"),content.getBytes());

            SortingFileByColumn sortingFileByColumn = new SortingFileByColumn(1,file);
            ArrayList<Map.Entry<Integer, String>> sortArray = new ArrayList<Map.Entry<Integer, String>>(sortingFileByColumn.Sort());
            Search searching = new Search("Lom", sortArray, file, 1);
            long time = System.currentTimeMillis();
            searching.searching();
            System.out.println("Время затраченное на поиск " + (System.currentTimeMillis()-time)+" мс");
        } catch (IOException | ExecutionException | InterruptedException ex) {
            ex.printStackTrace();

        }
    }



}