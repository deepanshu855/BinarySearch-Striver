package _1DArray;
// Find peak element

public class _13 {
    public static int findPeakElement(int[] nums) {
        // We'll use binary search for optimal because this question involves searching and it has a tendency of sorting.
        int n=nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int low=1; int high=n-2;

        // Code for 1 peak
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
                // Increasing curve peak on right
            else if(nums[mid]>nums[mid-1]) low=mid+1;
                // Decreasing curve peak on left side
            else if(nums[mid]>nums[mid+1]) high=mid-1;
                // Now this else will help to not to go to loop and make this single peak code working for multiple peak.
            else {
                low=mid+1;
                // or we can also do high=mid-1;
            }
        }

        return -1;
    }

    static void main(String[] args) {
        int result= findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(result);
    }
}
