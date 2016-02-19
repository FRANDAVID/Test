package 集合迭代删除;

import leetcode.IntegertoRoman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by weijin on 15/12/28.
 */
public class CollectionItera {
    public static void main(String[]args){

        CorrectListIter();
    }
    public static void ErrorListIter(){
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int value:list) {
            if(2==value){
                list.remove(value);
            }
        }
    }
    public static void CorrectListIter(){
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer value = it.next();
            if(value ==2){
                it.remove();
            }
        }
        System.out.println(list);

    }
}
