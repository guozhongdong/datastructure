package com.gzd.datastructure.suanfatujie.chapter4;

/**
 * @author guozhongdong
 * @date 2020/3/27 21:13
 *  通过使用递归方式求数组和
 */
public class Sum {

    public static void main(String[] args) {
        int[] nums = {2,4,6};
        System.out.println(new Sum().sum(nums));
        System.out.println(new Sum().count(nums));
        System.out.println(new Sum().maxNum(nums));
    }
    /**
     * 计算列表中的和
     * */
    public int sum(int[] arr){
        if (arr == null || arr.length ==0){
            return 0;
        }
        int n = arr[0];
        int[] temp = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            temp[i-1] = arr[i];
        }
        return n+sum(temp);
    }

    /**
     * 计算列表中的和
     * */
    public int maxNum(int[] arr){
        if (arr == null || arr.length ==0){
            return 0;
        }
        if (arr.length ==1){
            return arr[0];
        }
        int n = arr[0];
        int[] temp = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            temp[i-1] = arr[i];
        }

        return Math.max(n,maxNum(temp));
    }

    /**
     * 递归计算列表的元素
     * */
    public int count(int[] arr){
       if (arr==null || arr.length ==0){
           return 0;
       }
        int[] temp = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            temp[i-1] = arr[i];
        }
        return 1+count(temp);
    }
}
