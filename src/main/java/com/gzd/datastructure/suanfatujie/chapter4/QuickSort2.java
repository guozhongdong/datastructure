package com.gzd.datastructure.suanfatujie.chapter4;

import java.util.Arrays;

/**
 * @author guozhongdong
 * @date 2020/3/27 21:2
 * 快速排序
 * 找好递归法的基准条件，即是如果元素是一个或 是null，就不用排序了，直接返回
 * 照着python 的语法翻译的
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        int[] nums3 = {7,8,9};
        System.out.println(Arrays.toString(new QuickSort2().merge(nums1, nums2, nums3)));
        int[] nums = {2,3,6,1,8,4};
        System.out.println(Arrays.toString(new QuickSort2().quickSort(nums)));
    }
    public int[] quickSort(int[] arr){
        // 基线条件
        if (arr.length < 2){
            return arr;
        }
        //选择基准值
        int temp = arr[0];
        int[] pivot = new int[1];
        pivot[0] = arr[0];

        int n = 0;
        int m = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] <= temp){
                n++;
            }else{
                m++;
            }
        }
        int[] less = new int[n];
        int[] greater = new int[m];
        int h = 0;
        int g = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] <= temp){
                less[h] = arr[i];
                h++;
            }else{
                greater[g] = arr[i];
                g++;
            }
        }
        return merge(quickSort(less),pivot,quickSort(greater));
    }

    public int[] merge(int[] nums1,int[] nums2,int[] nums3){

        int[] sum = new int[nums1.length+nums2.length+nums3.length];
        for (int i = 0; i < nums1.length ; i++) {
            sum[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            sum[nums1.length+j] = nums2[j];
        }
        for (int k = 0; k < nums3.length; k++) {
            sum[nums1.length+nums2.length+k] = nums3[k];
        }
        return sum;
    }
}
