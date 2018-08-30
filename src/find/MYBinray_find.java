package find;

/**
 * Company lenovo.com
 * Copyright (C) 1984-2018 All Rights Reserved.
 *
 * @author david
 * @version MYBinray_find.java, v 0.1 2018-08-30 下午3:45 david
 * @project Test
 */
public class MYBinray_find {
    public static void main(String[] args) {
       int [] src = {1,3,5,9,10,11};
       int index = MYBinray_find.binray_find(15,src);
        System.out.println(index);
    }

    public static int binray_find(int desc,int[]arrays){
       int low = 0;
       int high = arrays.length-1;
       while(low<=high){
           int middle = (low+high)/2;
           if (desc ==arrays[middle]) {
               return middle;
           } else if (desc < arrays[middle]) {
               high = middle-1;
           } else if (desc > arrays[middle]) {
               low = middle+1;
           }else{
              return -1;
           }

       }
       return -1;
    }
}
