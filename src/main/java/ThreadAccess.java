import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;

public class ThreadAccess implements Callable<Integer> {
    private String searchString;
    private ArrayList<Map.Entry<Integer,String>> arrayList;
    private int minIndex;
    private int maxIndex;

    ThreadAccess(String searchString, ArrayList<Map.Entry<Integer,String>> arrayList, int minIndex, int maxIndex)
    {
        this.arrayList=arrayList;
        this.minIndex = minIndex;
        this.searchString = searchString;
        this.maxIndex = maxIndex;
    }

    @Override
    public Integer call() throws Exception {
        int result;
        for(int i=minIndex;i<maxIndex;i++)
        {
            String s1 = arrayList.get(i).getValue();
            //Thread.sleep(1);
            if(s1.startsWith(searchString))
            {
                result = i;
                return result;
            }
        }
        return -1;
    }
}
