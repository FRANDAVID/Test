package loadblance;

import java.util.ArrayList;
import java.util.List;

/**
 *  模拟nginx weight值 选择负载均衡服务器。
 *  权值算法
 * @author weijin
 *
 */
class Server{
	private String ip;
	private String port;
	public int weight;
	public Server(int weight){
		this.weight=weight;
	}
}
public class LoadBalancer{
	private static List<Server> list=new ArrayList<Server>();
	private static int totalWeight=0;
	static{//加载配置文件，将解析的服务器列表添加到list中.同时计算出总权重值

		Server s1 =new Server(1);
		Server s2 =new Server(2);
		Server s3 =new Server(15);
		Server s4 =new Server(5);
		Server s5 =new Server(7);
		list.add(s1);totalWeight = totalWeight+s1.weight;
		list.add(s2);totalWeight = totalWeight+s2.weight;
		list.add(s3);totalWeight = totalWeight+s3.weight;
		list.add(s4);totalWeight = totalWeight+s4.weight;
		list.add(s5);totalWeight = totalWeight+s5.weight;
	}
	private static LoadBalancer loadBalancer=new LoadBalancer();
 	private LoadBalancer(){}
	public static LoadBalancer getLoadBalancer(){
		return loadBalancer;
	}
	public Server getServer(){
		int sum=0;
		int rand=(int)(1+Math.random()*totalWeight);
		System.out.println("random==>"+rand);
		for(Server serv : list){////由概率区间值决定服务器的分配
			sum+=serv.weight;
			System.out.println("sum==>"+sum);
			if(rand<=sum){
				return serv;
			}else{
				continue;
			}
		}
		return null;//不会出现这种情况。
	}
	
	public static void main(String[]args)
	{
		Server s1 =new Server(1);
		Server s2 =new Server(2);
		Server s3 =new Server(15);
		Server s4 =new Server(5);
		Server s5 =new Server(7);
		LoadBalancer lb = new LoadBalancer();
		for(int i=0;i<10;i++)
		{
			System.out.println("return "+lb.getServer().weight);
			
		}
	}
}