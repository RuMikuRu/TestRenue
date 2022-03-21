<<<<<<< HEAD
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
=======
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

>>>>>>> main

public class Main {
    private static final HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
    public static void main(String[] args) throws IOException {
<<<<<<< HEAD
        try{
            Path file = Paths.get("src/main/resources/airports.dat");
            SortingFileByColumn sortingFileByColumn = new SortingFileByColumn(1,file);
            ArrayList<Map.Entry<Integer, String>> sortArray = new ArrayList<Map.Entry<Integer, String>>(sortingFileByColumn.Sort());
            Search searching = new Search("Lom", sortArray);
            searching.searching();
=======
        Path file =  Paths.get("src/main/resources/airports.dat");
        //TODO Сделать выборку по столбцам и отсортировать и всё, отдыхать...
        try(InputStream in = Files.newInputStream(file);
            BufferedReader readerStr = new BufferedReader(new InputStreamReader(in));
        ){
            //FileReader reader = new FileReader(String.valueOf(file));
            String line = readerStr.readLine();
            int i=1;
            long time = System.currentTimeMillis();
            while(line!=null) {
                if(Parser.getFirstEntry(line, "Bo")>0)
                {
                    System.out.println("строка " + i);
                }


                line = readerStr.readLine();
                i++;
            }
            System.out.println(System.currentTimeMillis() - time);
            System.out.println(i);
>>>>>>> main
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }



}