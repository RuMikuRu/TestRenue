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
                for (int i=0;i< arrayList.size();i++)
                {
                    try{
                        String s1 = arrayList.get(i).getValue();
                        Thread.sleep(1);
                        if(s1.contains(searchString))
                        {
                            //result[i] = Integer.parseInt(arrayList.get(i).getValue());
                            System.out.println(arrayList.get(i).getKey());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        threads.add(thread);

        threads.forEach(thread1 -> {
            try{
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
    }
}
