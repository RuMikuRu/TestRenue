import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Search {
    private String searchString;
    private ArrayList<Map.Entry<Integer,String>> arrayList;

    Search(String searchString, ArrayList<Map.Entry<Integer, String>> arrayList)
    {
        this.searchString = searchString;
        this.arrayList = arrayList;
    }

    public void searching()
    {
        System.out.println("Начинаю поиск");
        List<Thread> threads = new LinkedList<>();
        //final int[] result = new int[arrayList.size()];
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                if (compareString(arrayList.get(arrayList.size()/2).getValue(), searchString))
                {
                    i = arrayList.size()/2;
                }
                else
                {
                    i = arrayList.size();
                }
                for (i=0;i< arrayList.size();i++)
                {
                    String s1 = arrayList.get(i).getValue();
                    //Thread.sleep(1);
                    if(s1.startsWith(searchString))
                    {
                        //result[i] = Integer.parseInt(arrayList.get(i).getValue());
                        System.out.println(arrayList.get(i).getKey());
                    }
                }
            }
        });
        thread.start();
        threads.add(thread);
        long time = System.currentTimeMillis();
        threads.forEach(thread1 -> {
            try{
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.currentTimeMillis() - time);
        //System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
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
