package com.gzd.datastructure.chapter9;

/**
 * @author guozhongdong
 * @date 2020/3/23 22:20
 * 选择排序
 *
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {9,1,5,8,3,7,4,6,2};
        new SelectSort().selectSorts(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public void selectSorts(int arr[]){
        int min;
        for (int i = 0; i < arr.length; i++) {
             min = i;
            for (int j = i+1;j<arr.length;j++){
                // 只作比较的次数，最终找到一个最小值,循环了n-i次，但是只是交换了一次
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            //出来交换最小是
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
