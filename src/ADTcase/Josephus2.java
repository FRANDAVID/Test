package ADTcase;


import java.util.ArrayList;  
  
public class Josephus2  
{  
    private static int removeNM(int n, int m)  
    {  
        ArrayList<Integer> list = new ArrayList<Integer>();  
        for (int i = 1; i <=n; i++)  
        {  
            list.add(new Integer(i));  
        }  
        int removed = 0;  
        int j=0;  
        while (list.size() > 1)  
        {  
            removed = (removed + m - 1) % list.size();  
            System.out.print(list.get(removed)+"\t");  
            if(++j%10==0) System.out.println();  
            list.remove(removed);  
        }  
        return list.get(0).intValue();  
    }  
  
    public static void main(String[] args) throws Exception  
    {  
        removeNM(41, 3);  
        System.out.println(removeNM(41, 3));  
    }  
}  