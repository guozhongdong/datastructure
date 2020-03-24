package com.gzd.datastructure.chapter8;

/**
 * @author guozhongdong
 * @date 2020/3/22 19:25
 *
 * 折半查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,16,24,35,47,59,62,73,88,99};
        int num = new BinarySearch().binarySearch(arr,62);
        System.out.println(num);
    }

    public int binarySearch(int[] arr,int n){
        int low = 0;
        int high = arr.length-1;
        int mid;
        while (low <= high){
           // mid = (low+high)/2;
            mid = low + (high - low) *(n - arr[low])/(arr[high]-arr[low]);
            if (arr[mid] > n){
                high = mid -1;

            }else if(arr[mid] < n){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return 0;
    }
}
