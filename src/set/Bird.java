package set;


class Bird implements Comparable<Bird>
{
    int size;
      
    public Bird(int s)
    {
        size = s;
    }
      
    public String toString()
    {
        return size + "??????";
    }
  
    @Override
    public int compareTo(Bird o)
    {
        return size - o.size;
    }
      
}