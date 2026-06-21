package _1DArray;
// Search Insert position

public class _4 {
    public static int searchInsert(int[] nums, int target) {
        // Same code as lower bound because we need to find the smallest index such that nums[index]>=target.

        int low=0, high=nums.length-1;
        int ans=nums.length;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            } else {
                low=low+1;
            }
        }

        return ans;
    }

    static void main(String[] args) {
        int result= searchInsert(new int[]{1,3,5,6},7);
        System.out.println(result);
    }
}
