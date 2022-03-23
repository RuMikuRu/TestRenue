import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutionException;


public class Main {
    private static final HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
    public static void main(String[] args) throws IOException {
        try{
            Scanner scanner = new Scanner(System.in);
            String textSearch = scanner.next();
            System.out.println("В ведите строку...");
            Path file = Paths.get("src/main/resources/airports.dat");
            int column = Integer.parseInt(args[0]);

            //String content = Files.lines(Path.of(String.valueOf(file))).sorted(Comparator.comparing(line->Integer.parseInt(line.split(",")[1])))
                 //   .collect(Collectors.joining("\n"));
            //Files.write(Paths.get("Sorted"),content.getBytes());

            SortingFileByColumn sortingFileByColumn = new SortingFileByColumn(column,file);
            ArrayList<Map.Entry<Integer, String>> sortArray = new ArrayList<Map.Entry<Integer, String>>(sortingFileByColumn.Sort());
            Search searching = new Search(textSearch, sortArray, file, column);

            long time = System.currentTimeMillis();
            searching.searching();
            System.out.println("Время затраченное на поиск " + (System.currentTimeMillis()-time)+" мс");

        } catch (IOException | ExecutionException | InterruptedException ex) {
            //ex.printStackTrace();
            System.out.println("Файл не существует");
        }
    }



}