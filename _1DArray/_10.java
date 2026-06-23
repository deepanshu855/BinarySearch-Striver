package _1DArray;
// Find minimum in Rotated Sorted Array

public class _10 {
    public static int findMin(int[] nums) {
        // Same thinking as search in rotated array. -> Indentify the sorted half right or left
        int low=0; int high=nums.length-1;
        int ans=Integer.MAX_VALUE;

        while(low<=high){
            int mid=low+(high-low)/2;

            // Left sorted.
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            // Right sorted -> nums[mid]<=nums[high];
            else {
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }

        return ans;
    }

    static void main(String[] args) {
        int result= findMin(new int[]{3,4,5,1,2});
        System.out.println(result);
    }
}
