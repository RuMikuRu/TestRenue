import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;


public class Search {
    private String searchString;
    private ArrayList<Map.Entry<Integer,String>> arrayList;
    private Path fileName;
    private int column;
    Search(String searchString, ArrayList<Map.Entry<Integer, String>> arrayList, Path fileName, int column)
    {
        this.searchString = searchString;
        this.arrayList = arrayList;
        this.fileName = fileName;
        this.column=column;
    }

    public void searching() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ThreadAccess threadA = new ThreadAccess(searchString, arrayList,0, (int) Math.sqrt(arrayList.size()));
        ThreadAccess threadB = new ThreadAccess(searchString, arrayList,(int) Math.sqrt(arrayList.size()), arrayList.size());
        Future<Integer> futureA = executor.submit(threadA);
        Future<Integer> futureB = executor.submit(threadB);
        int tempTwo = futureA.get();
        int tempOne = futureB.get();
        int index=0;
        if(tempOne>=0)
        {
            index=tempOne;
        }else if (tempTwo>=0)
        {
            index=tempTwo;
        }
        else{
            System.out.println("Не найдено");
        }
        int i=index;
        int j=0;
        while (arrayList.get(i).getValue().startsWith(searchString))
        {
            i++;
        }
        int[] foundIndex = new int[i-index];
        i=index;
        while(arrayList.get(i).getValue().startsWith(searchString))
        {
            foundIndex[j] = arrayList.get(i).getKey();
            j++;
            i++;
        }
        Arrays.sort(foundIndex);
        new PrintFoundLineFromFile(foundIndex, arrayList.size(), fileName, column).print();
    }
}
