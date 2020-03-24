package com.gzd.datastructure.chapter9;

/**
 * @author guozhongdong
 * @date 2020/3/23 22:35
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {9,1,5,8,3,7,4,6,2};
        new InsertSort().insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public void insertSort(int[] nums){
        // 第一次遍历，遍历所有的元素，从1 开始，把1位置的元素，当成一个目标元素，

        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] < nums[i-1]){ // 判断当前元素跟上一个元素相比，是否是小的那个，是的话，把小的
                // 元素赋值给一个临时变量
                int temp = nums[i];
                // 将记录后移
                int j ;
                // 判断i 前面是否还有比temp 小的元素了，如果有，则插入到他的前面，整体后移一位，
                for ( j = i-1; j>=0; j--) {
                    if (nums[j] > temp){
                        nums[j+1] = nums[j];
                    }else{
                        break;
                    }

                }
                nums[j+1] = temp;


            }
        }
    }
}
