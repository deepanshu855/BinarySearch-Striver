package _1DArray;
// Floor and ceil in sorted array

import java.util.Arrays;

public class _5 {
    public static int[] getFloorAndCeil(int[] nums, int x) {
        int floor=-1;
        int ceil=-1; // Ceil is same as lower bound.

        int low=0;
        int high=nums.length-1;

        // This is for ceil
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>=x){
                ceil=nums[mid];
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        low=0;
        high=nums.length-1;
        // This is for floor
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]<=x){
                floor=nums[mid];
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return new int[]{floor,ceil};
    }

    static void main(String[] args) {
        int[] result= getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 5);
        System.out.println(Arrays.toString(result));
    }
}
