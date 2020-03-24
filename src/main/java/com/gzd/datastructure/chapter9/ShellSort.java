package com.gzd.datastructure.chapter9;

/**
 * @author guozhongdong
 * @date 2020/3/24 15:57
 * 希尔排序，不是一个稳定的排序，但是时间复杂度比其他几种排序，优化了，
 * 是对插入排序的改进，插入排序是一个一个的比较，这个是跳跃一定的幅度，尽可能的保证基本有序，
 * 之后减少幅度，因为基本有效了，再小幅度的变动
 * 基本有序：小的基本在前面，大的基本上在后面，不大不小的基本在中间，
 *
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {9,1,5,8,3,7,4,6,2};
        new ShellSort().shellSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    public void shellSort(int[] nums){
        // 跳跃量，是关键点，是算法提高效率的核心
        int increment = nums.length;
        while (increment > 0){
            increment = increment/3;
            for (int i = increment; i < nums.length ; i++) {
                if (nums[i] < nums[i-increment]){
                    int temp = nums[i];
                    int j ;
                    // 判断i 前面是否还有比temp 小的元素了，如果有，则插入到他的前面，整体后移一位，
                    for ( j = i-increment; j>=0 && temp < nums[j]; j-=increment) {
                        nums[j+increment] = nums[j];
                    }
                    nums[j+increment] = temp;
                }
            }
        }

    }

}
