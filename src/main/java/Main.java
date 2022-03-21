import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static final HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
    public static void main(String[] args) throws IOException {

        //TODO Сделать выборку по столбцам и отсортировать и всё, отдыхать...
        try{
            Path file = Paths.get("src/main/resources/airports.dat");
            SortingFileByColumn sortingFileByColumn = new SortingFileByColumn(1,file);
            ArrayList<Map.Entry<Integer, String>> sortArray = new ArrayList<Map.Entry<Integer, String>>(sortingFileByColumn.Sort());
            Search searching = new Search("Boi", sortArray);
            searching.searching();



            String template = "Boi";
            int templateLen = template.length();
            int column=2;
            long time = System.currentTimeMillis();
            List<String> str = new ArrayList<String>();
            Files.lines(file).forEach(line->{
                char separator = ',';
                int[] index = IntStream.range(0, line.length()).filter(i->line.charAt(i) == separator).toArray();
                if(line.substring(index[column-2],index[column-1]).contains(template))
                {
                    str.add(line);
                }
            });
            String[][] array = new String[str.size()][];
            for(int i=0;i<str.size();i++)
            {
                array[i] = str.get(i).split(",");

            }

            String[] temp = new String[array.length];
            boolean changed = true;
            while(changed)
            {
                changed=false;
                for(int i=0;i< array.length-1;i++)
                {
                    if(compareString(array[i][column-1],array[i+1][column-1]))
                    {
                        temp=array[i];
                        array[i] = array[i+1];
                        array[i+1]=temp;
                        changed=true;
                    }
                }
            }
            //for(int i=0;i< array.length;i++)
                //System.out.println(Arrays.toString(array[i]));
            //System.out.println(System.currentTimeMillis() - time);
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