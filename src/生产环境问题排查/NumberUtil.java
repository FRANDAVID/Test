package 生产环境问题排查;

public class NumberUtil {
 
    public int sum(){
        int result = 0;
        for(int i = 0; i< 100; i++){
            result += i * i;
        }
        return result;
    }
 
    public static void main(String[] args){
        while (true) {
            Thread.currentThread().setName("计算");
            NumberUtil util = new NumberUtil();
            int result = util.sum();
            System.out.println(result);
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
 
            }
        }
    }
}
/*
*
*
* 编译：javac -d . NumberUtil.java，定位到 NumberUtil.java 所在目录，然后执行此命令行，
* 将会在当前目录（.表示当前目录）生成包名所示的目录结构，kite/lab/utils/NumberUtil.class

执行：java kite.lab.utils.NumberUtil 即可　　
* */