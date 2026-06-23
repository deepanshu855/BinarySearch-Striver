package _1DArray;
// Find out how many times the array is rotated

import java.util.ArrayList;
import java.util.Arrays;

public class _11 {
    public static int findKRotation(ArrayList<Integer> nums) {
        // Same thinking as find minimum in rotated array
        int low=0; int high=nums.size()-1;
        int ans=Integer.MAX_VALUE;
        int idx=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            // Left sorted
            if(nums.get(low)<=nums.get(mid)){
                if(ans>=nums.get(low)){
                    ans=nums.get(low);
                    idx=low;
                }
                low=mid+1;
            }
            // Right sorted
            else {
                if(ans>=nums.get(mid)){
                    ans=nums.get(mid);
                    idx=mid;
                }
                high=mid-1;
            }
        }

        return idx;
    }

    static void main(String[] args) {
        ArrayList<Integer> nums= new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
        int result= findKRotation(nums);
        System.out.println(result);
    }
}
