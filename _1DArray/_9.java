package _1DArray;
// Search in a sorted array -II

public class _9 {
    public static boolean search(int[] nums, int target) {
        // Trying the same code as Search in sorted Array I
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target) return true;
            else if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low=low+1;
                high=high-1;
            }
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            }
            else {
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            }
        }

        return false;
    }

    static void main(String[] args) {
        boolean result= search(new int[]{2,5,6,0,0,1,2},0);
        System.out.println(result);
    }
}
