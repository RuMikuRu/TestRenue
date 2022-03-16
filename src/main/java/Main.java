import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
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
            readerStr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //System.out.print(Parser.getFirstEntry("HeSheIt", "She"));
    }
}