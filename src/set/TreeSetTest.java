package set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest
{
    public static void main(String[] args)
    {
        TreeSet<Bird> bSet = new TreeSet<Bird>();
        bSet.add(new Bird(1));
        bSet.add(new Bird(3));
        bSet.add(new Bird(2));
          
        Iterator<Bird> iter = bSet.iterator();
          
        while (iter.hasNext())
        {
            Bird bird = (Bird) iter.next();
            System.out.println(bird);
        }
    }
}