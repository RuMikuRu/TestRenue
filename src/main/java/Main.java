import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static final HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
    public static void main(String[] args) throws IOException {
        try{
            Path file = Paths.get("src/main/resources/airports.dat");
            SortingFileByColumn sortingFileByColumn = new SortingFileByColumn(1,file);
            ArrayList<Map.Entry<Integer, String>> sortArray = new ArrayList<Map.Entry<Integer, String>>(sortingFileByColumn.Sort());
            Search searching = new Search("Boi", sortArray);
            searching.searching();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Boolean compareString(String s1, String s2)
    {
        int comparedResult = s1.compareTo(s2);

        if(comparedResult>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}