import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintFoundLineFromFile {
    private int[] numberLine;
    private Path fileName;
    private int fileLineSize;
    private int column;
    PrintFoundLineFromFile(int[] numberLine, int fileLineSize, Path fileName, int column)
    {
        this.numberLine = numberLine;
        this.fileLineSize = fileLineSize;
        this.fileName = fileName;
        this.column = column;
    }

    public void print()
    {
        List<String> arrayPrint = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(fileName)))){
            int indexForNumberLine=0;
            for(int i=0;i<fileLineSize;i++)
            {
                String s1 = br.readLine();
                if(numberLine.length>indexForNumberLine) {
                    if (s1.startsWith(String.valueOf(numberLine[indexForNumberLine]))) {
                        arrayPrint.add(s1);
                        indexForNumberLine++;
                    }
                }
            }
            String[][] pleaseWork = new String[arrayPrint.size()][];
            for(int i=0;i< arrayPrint.size();i++)
            {
                pleaseWork[i] = arrayPrint.get(i).split(",");
            }

            String[] temp = new String[pleaseWork.length];
            boolean changed = true;
            while(changed)
            {
                changed=false;
                for(int i=0;i< pleaseWork.length-1;i++)
                {
                    if(compareString(pleaseWork[i][column],pleaseWork[i+1][column]))
                    {
                        temp=pleaseWork[i];
                        pleaseWork[i]=pleaseWork[i+1];
                        pleaseWork[i+1]=temp;
                        changed=true;
                    }
                }
            }

            for(int i=0;i< pleaseWork.length;i++)
                System.out.println(Arrays.toString(pleaseWork[i]).replaceAll("^\\[|\\]$", ""));

            System.out.println("Колличество найденных строк " + pleaseWork.length);

        } catch (IOException e) {
            e.printStackTrace();
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
