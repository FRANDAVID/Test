package operator;

import java.io.IOException;

/**
 * 利用位操作来找出消失的运算符
 * 
 * @author weijin
 * 
 */
public class DisapperNum {

    public static void main(String[] args) {
        int l = 15;
        int a[] = new int[] { 1, 347, 6, 9, 13, 65, 889, 712, 889, 347, 1, 9, 65, 13, 712 };
        int lostNum = 0;
        for (int i = 0; i < l; i++)
            lostNum ^= a[i];
        System.out.println("缺失的数字为:" + lostNum);
        if (true) {
            System.out.println("222");
        }
        for (int i = 0; i < 10; i++) {

        }
        switch (l) {
            case 1:
                break;
            case 2:
                break;
        }
    }
    /**
     * 
    * @Title: test  
    * @param a
    * @param b
    * @return void    返回类型  
    * @Description: TODO(这里用一句话描述这个方法的作用)     
    * @authon weijin
    * @date:2015年9月2日 下午3:30:13
     */
    public void test(int a ,int b)  {

    }
}
