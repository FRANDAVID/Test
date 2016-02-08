package linkedList;

 
/* 先定义一个Node类用来存储节点的值域和指针域
 * 即当前节点中的值和后面节点的方法
 * 在C中就是相当与定义一个结构体类型一个数据域和指针域的方法
 */
class LNode{//这个写法已经非常固定了 设置两个属性分别用set函数和get函数来得到这两个属性
	private int data;
	private LNode next;//这个和String应该比较相似的用法，类名用来表示数据类型，表示next的数据类型也是节点
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return this.data ;
	}
	public void setNext(LNode next){
		this.next = next;
	}
	public LNode getNext(){
		return this.next;
	}
}
/*
 * 定义一个链表主类，并且定义各种对链表操作的方法
 */
public class Linklist {
	
		 public LNode head;//定义一个头结点

/*
 * 定义一个创建链表的方法
 * 该方法称之为 ：尾插法：新产生的节点从尾部插入链表
 */
		 public void createlink(int [] a){
		   LNode pnew;//定义pnew表示新产生的结点
		   LNode ptail=new LNode();//为尾节点分配堆内存
		   head=ptail;//初始时是头结点与尾节点相等
		   for(int i=0;i<a.length;i++){
		   pnew=new LNode();//为新产生的节点分配堆内存
		   pnew.setData(a[i]);//传递data值
		   ptail.setNext(pnew);//把新产生的节点设置为ptail的后继节点
		   pnew.setNext(null);//把新产生的节点的后继节点设为空
		   ptail=pnew;//移动 ptail节点的位置使之一直指向尾部
		   }
		 }
 
/*
 * 定义判断链表中元素是否存在的方法
 */
		 public void seachlink(int value){
			 LNode ptr;
			  ptr=head.getNext();
			  while(ptr!=null){//在节点非空的情况下寻找匹配的的值
			   if(value==ptr.getData()){//匹配成功是
			    System.out.println("找到数据:"+ptr.getData());
			    break;//退出循环
			   }
			   else{//当当前值不是要查找的值时，查找下一个
			    ptr=ptr.getNext();
			   } 
			  }
			  if(ptr==null)//链表遍历完毕，没有找到时
			   System.out.println("链表中没有要查找数据");
			 }
/*
 * 定义一个删除节点的方法
 */
		 public void deletelink(int value){
			  LNode ptr;
			  LNode p;
			  p=head;
			  ptr=head.getNext();
			  while(ptr!=null){
			   if(value==ptr.getData()){//判断链表中的当前值是否是要删除的节点
			    p.setNext(ptr.getNext());//把ptr的后继节点设置为p的后继节点，即在形式上在链表中删除了ptr节点
			   // System.gc();
			    System.out.println("删除数据"+value+"成功！");
			    break;
			   }
			   else{
			    p=ptr;//p指向ptr位置
			    ptr=ptr.getNext();//ptr指向其直接后继位置
			   }
			  }
			  if(ptr==null)
			   System.out.println("链表中没有要删除的数据！");
			 }
/*
 * 定义插入节点的方法
 */
	 public void insertlink(int pos,int value){//两个参数，一个表示插入的位置，另一个表示插入的值
			  LNode ptr;
			  LNode pnew;//实例化新节点
			  ptr=head.getNext();
			  while(ptr!=null){
			   if(pos==ptr.getData()){
			    pnew=new LNode();
			    pnew.setData(value);
			    pnew.setNext(ptr.getNext());
			    ptr.setNext(pnew);//
			    System.out.println("插入数据"+value+"成功！");
			    break;
			   }
			   else{
			    ptr=ptr.getNext();
			   }
			  }
			  if(ptr==null)
			   System.out.println("插入数据失败！");
			 }

		 
		 
/*
 * 定义一个输出链表内容方法
 */
		 public void printlink(){
		  LNode ptr;//实例化一个节点
		  ptr=head.getNext();//该节点取得头结点的后继节点
		  while(ptr!=null){
		   System.out.print(ptr.getData()+"->");
		   ptr=ptr.getNext();
		  }
		  System.out.println(" NULL");
		 }

/*
 * 下面给出一个测试用例，用数组创建一个整型的链表，并且把它输出		 
 */
     public static void main(String args[]){
	   int a[]=new int [10];
	   for(int i=0;i<a.length;i++){
	   a[i]=i;
	   }
	   Linklist list=new Linklist();
	   list.createlink(a);
	   System.out.println(" 链表输出如下：");
	   list.printlink();
	   System.out.println(" 插入元素后链表的输出如下：");
	   list.printlink();
	   
	   }
}
	