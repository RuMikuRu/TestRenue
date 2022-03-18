import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    private static final HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
    String line;
    public static void main(String[] args) throws IOException {
        //TODO Сделать выборку по столбцам и отсортировать и всё, отдыхать...
        try{
            Path file = Paths.get("src/main/resources/airports.dat");

            String template = "Ni";
            int templateLen = template.length();

            for (int i = 0; i <= 8219; i++) {
                offsetTable.put((char) i,  templateLen);
            }
            for (int i = 0; i < templateLen - 1; i++) {
                offsetTable.put(template.charAt(i),  (templateLen - i - 1));
            }
            int column=4;
            long time = System.currentTimeMillis();

            Files.lines(file).forEach(line->{
                //int i=1;
                //while(line!=null) {
                    //if(Parser.getFirstEntry(line, template, offsetTable)>0)
                    //{
                        //System.out.println(line);
                        //System.out.println(line.indexOf(","));
                    //}
                   // i++;
                //}
                //System.out.println(i);
                char separator = ',';
                int[] index = IntStream.range(0, line.length()).filter(i->line.charAt(i) == separator).toArray();
                if(line.substring(index[column-2],index[column-1]).contains(template))
                    System.out.println(line);
            });
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //System.out.print(Parser.getFirstEntry("HeSheIt", "She"));
    }
}