package com.gzd.datastructure.chapter9;

/**
 * @author guozhongdong
 * @date 2020/3/24 20:16
 * 快速排序：通过一趟排序，将待排序记录分割为两个子集，左边的记录均比选择的关键字小，
 * 右边的记录均比关键字大，递归下去。
 *
 * 快慢取决于关键key所在的位置
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {9,1,5,8,3,7,4,6,2};
        new QuickSort().quickSort(nums,0,8);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public void quickSort(int[] nums,int low,int high){
        int key;
        if (low < high){
            key = partition(nums,low,high);
            quickSort(nums,low,key-1);
            quickSort(nums,key+1,high);

        }
    }

    public int partition(int[] nums,int low,int high){
        int data  = nums[low];
        while (low < high){
            // 寻找比关键字小的，交换位置，放到关键字前面，如果大于关键字，则
            //从后往前继续寻找，
            while (low < high && nums[high] >= data){
                high --;
            }
            swap(nums,low,high);
            //从前往后，寻找比关键字大的，交换位置，
            while (low < high && nums[low] <= data){
                low++;
            }
            swap(nums,low,high);
            // 都分好了之后，记录关键字所在的位置，一分为二，给下次递归继续
        }
        return low;
    }
    public void swap(int[] nums,int low,int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
