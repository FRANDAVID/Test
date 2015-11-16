package dikaer;

import java.util.ArrayList;
import java.util.List;

public class Snippet{
	    public static void main(String[]args) {
	    	Snippet s = new Snippet();
	        String[] a1 = new String[]{"1", "2", "3"};
	        String[] a2 = new String[]{"3"};
	        String[] a3 = new String[]{"2", "3", "4"};
	        String[] a4 = new String[]{"3"};
	        String[] a5 = new String[]{"9", "8"};
	        List<String[]> list = new ArrayList<String[]>();
	        list.add(a1);
	        list.add(a2);
	        list.add(a3);
	        list.add(a4);
	        list.add(a5);
	        String[] result = s.getNDis(list);
	        for (String item : result)
	            System.out.println(item);
	    }

	    //N个集合的笛卡尔积
	    public String[] getNDis(List<String[]> a) {
	        String[] result = a.get(0);
	        for (int i = 1; i < a.size(); i++)
	            result = getDis(result, a.get(i));
	        return result;
	    }

	    //两个集合的笛卡尔积
	    public String[] getDis(String[] a, String[] b) {
	        String[] result = new String[a.length * b.length];
	        int k = 0;
	        for (String i : a)
	            for (String j : b) {
	                result[k] = i + j;
	                k++;
	            }
	        return result;
	    }
}