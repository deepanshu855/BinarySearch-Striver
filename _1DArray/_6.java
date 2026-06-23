package _1DArray;
// First and last occurence

import java.util.Arrays;

public class _6 {
    public static int[] searchRange(int[] nums, int target) {
        int start=-1;
        int end=-1;

        int low=0;
        int high=nums.length-1;

        // Instead of finding both first and last occurence in single loop.
        // Try to find both first and last occurence in different loops.

        // First occurence. it is LOWER BOUND. smallest index such that nums[idx]>target
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                start=mid;
                high=mid-1;
            } else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }

        low=0;
        high=nums.length-1;
        // Last occurence.
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                end=mid;
                low=mid+1;
            } else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }

        return new int[]{start,end};
    }

    static void main(String[] args) {
        int[] result= searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println(Arrays.toString(result));
    }
}
