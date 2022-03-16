import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //TODO Сделать выборку по столбцам и отсортировать и всё, отдыхать...
        try{
            File file = new File("src/main/resources/airports.dat");

            FileReader reader = new FileReader(file);
            BufferedReader readerStr = new BufferedReader(reader);

            String line = readerStr.readLine();
            int i=1;
            long time = System.currentTimeMillis();
            while(line!=null) {
                if(Parser.getFirstEntry(line, "Boi")>0)
                {
                    System.out.println("строка " + i);
                }


                line = readerStr.readLine();
                i++;
            }
            System.out.println(i);
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //System.out.print(Parser.getFirstEntry("HeSheIt", "She"));
    }
}