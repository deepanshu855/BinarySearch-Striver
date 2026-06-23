package _1DArray;
// Search in a sorted array -I

public class _8 {
    public static int search(int[] nums, int target) {
        // Using binary search.
        // Main thinking -> It is to identify the sorted half and check for target and eliminate the unwanted half.

        int low=0; int high=nums.length-1;

        // 100% one of the half either right or left will be sorted
        while(low<=high){
            int mid= low+(high-low)/2;

            if(nums[mid]==target) return mid;
                // Left half is sorted
            else if(nums[low]<=nums[mid]){
                // Target is present in half
                if(nums[low]<=target && target<=nums[mid]){
                    // Eliminate the right half
                    high=mid-1;
                } else {
                    // Eliminate the left half target in right half
                    low=mid+1;
                }
            }
            // Right half is sorted
            else {
                // Target is present in half
                if(nums[mid]<=target && target<=nums[high]){
                    // Eliminate the left half
                    low=mid+1;
                } else {
                    // Eliminate the right half target in left half
                    high=mid-1;
                }
            }
        }

        return -1;
    }

    static void main(String[] args) {
        int result= search(new int[]{4,5,6,7,0,1,2},0);
        System.out.println(result);
    }
}
