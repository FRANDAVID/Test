package 布隆过滤器.bloomFilter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.BitSet;

public class BloomFilter {
	
	/* BitSet初始分配2^24个bit */ 
	private static final int DEFAULT_SIZE =1<<24; //each filter is 2^24 bits, equal 4MB 
	/* 不同哈希函数的种子，一般应取质数 */
	private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37, 61 };
	private BitSet bitSet = new BitSet(DEFAULT_SIZE);
	/* 哈希函数对象 */ 
	private SimpleHash[] func =new SimpleHash[seeds.length];

	public BloomFilter() 
	{
		for (int i =0; i < seeds.length; i++)
		{
			func[i] =new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		BloomFilter filter = new BloomFilter();
		filter.add("shengeng");
		filter.add("hujun");
		filter.add("Hello");
		filter.add("大众点评");
		
		String fileName = "ourbitset";
		filter.persistBitSet(fileName);
		filter.bitSet = null;
		filter.loadPersistedBitSet(fileName);
		
		boolean b1 = filter.contains("shengeng");
		boolean b2 = filter.contains("hello");
		boolean b3 = filter.contains("大众点评");
		boolean b4 = filter.contains("百度");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);

	}

	// 将字符串标记到bits中
	public void add(String value) 
	{
		for (SimpleHash f : func) 
		{
			bitSet.set(f.hash(value), true);
		}
	}

	//判断字符串是否已经被bits标记
	public boolean contains(String value) 
	{
		if (value ==null) 
		{
			return false;
		}
		boolean ret =true;
		for (SimpleHash f : func) 
		{
			ret = ret && bitSet.get(f.hash(value));
		}
		return ret;
	}

	/* 哈希函数类 */
	public static class SimpleHash 
	{
		private int cap;
		private int seed;
	
		public SimpleHash(int cap, int seed) 
		{
			this.cap = cap;
			this.seed = seed;
		}
	
		//hash函数，采用简单的加权和hash
		public int hash(String value) 
		{
			int result =0;
			int len = value.length();
			for (int i =0; i < len; i++) 
			{
				result = seed * result + value.charAt(i);
			}
			return (cap -1) & result;
		}
	}
	
	
	/*
	 * This function is for persistence of bitset.
	 */
	public void persistBitSet(String fileName) throws IOException{
		File file = new File(fileName);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(this.bitSet);
		objectOutputStream.close();
	}
	
	/*
	 * This function is to load persisted bitset.
	 */
	public void loadPersistedBitSet(String fileName) throws IOException, ClassNotFoundException{
		File file = new File(fileName);
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		BitSet bitSet = (BitSet) objectInputStream.readObject();
		
		this.bitSet = bitSet;
	}
	
}
