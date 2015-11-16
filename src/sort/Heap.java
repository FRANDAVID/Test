package sort;

//http://www.java3z.com/cwbwebhome/article/article1/1340.html?id=4633
import java.util.Scanner;  
 
public class Heap {  
  
    private int[] data;  
  
    /*输入数组元素,数组下标从1开始*/  
    public void input() {  
        System.out.println("请输入数组大小");  
        Scanner scanner = new Scanner(System.in);  
        int n = scanner.nextInt();  
        data = new int[n + 1];  
        System.out.println("输入数组元素");  
        for (int i = 1; i <= data.length-1; i++) {  
            data[i] = scanner.nextInt();  
        }  
        System.out.println("输入完成");  
    }  
      //随机数据测试
    public void ramData(){
         int n=50;
         data = new int[n + 1];  
         for(int i=1;i<=n;i++)
           data[i]=java.util.concurrent.ThreadLocalRandom.current().nextInt(1000);
   }


 
   //测试数据：
   //第一组：1 7 9 3 10 16 4 14 2 8
  //第二组：17 8 84 2 45 94
   //第三组：10 32 1 9 5 7 12 0 4
   public static void main(String args[]){
          Heap h=new Heap();
              // h.input();
              h.ramData();
           System.out.println("堆排序前：");
               h.print();
               h.heapSort();
          System.out.println("========================================");
          System.out.println("堆排序后：");
              h.print();
  }


    /** 
     * 调整堆，使其满足堆得定义 
     * @param i 
     * @param n 
     */  
    public void adjust(int i, int n) {  
        
        int child;  
        for (; i <= n / 2; ) {  
            child = i * 2;  
           // System.out.println("child="+child);
            if(child+1<=n&&data[child]<data[child+1])  
                child+=1;/*使child指向值较大的孩子*/  
            if(data[i]<data[child]){  
                swap(i, child);  
                /*交换后，以child为根的子树不一定满足堆定义，所以从child处开始调整*/  
                i = child;  
               
            }  else break;
        }  
    }  
  
    public void heapSort() {  
        /*根据树的性质，树节点前一半一定是分支节点，即有孩子的，所以我们从分支节点开始调整出初始堆*/  
        for (int i = data.length / 2; i > 0; i--)  
            adjust(i, data.length-1);  
        System.out.println("=================================================");
        System.out.println("调整后的初始堆：");
          print();
        for (int i = data.length-1; i > 0; i--) {  
            /*把根节点跟最后一个元素交换位置，调整剩下的n-1个节点，即可排好序*/  
            swap(1, i);  
            adjust(1, i - 1);  
        }  
    }  
  
    public void swap(int i, int j) {  
        int temp = data[i];  
        data[i] = data[j];  
        data[j] = temp;  
    }  
  
    public void print() {  
        for (int i = 1; i < data.length; i++) {  
            System.out.print(data[i]+" ");  
        }  
        System.out.println();  
    }  
  
}  
