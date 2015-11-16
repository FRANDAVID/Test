package FibonacciSequence;

import org.junit.Test;

public class badFibona {
	public  long fib(long n)
	{
	    return (n == 1 || n == 2) ? 1 : fib(n - 1) + fib(n - 2);
	}
	
	public static long goodFib(long n)
	{
	    if (n == 1 || n == 2)
	    {
	        return 1;
	    }
	    long m1 = 1, m2 = 1;
	    for (long i = 3; i <= n; i++)
	    {
	        m2 = m1 + m2;
	        m1 = m2 - m1;
	    }
	 
	    return m2;
	}
	@Test
	public void testfib(){
		System.out.println(fib(3));
	}
	
	@Test
	public void testGoodFib(){
		System.out.println(goodFib(50));
	}
}

