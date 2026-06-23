package _1DArray;
// Single element in sorted array

public class _12 {
    public static int singleNonDuplicate(int[] nums) {
        // Think of index Patter in sorted array.
        // (even,odd)=> element is in right half -> eliminate left half
        // (odd,evem)=> element is in left half -> eliminate right half
        // Now using this we'll eliminate the half which doesn't contains the element.

        // Handling edge cases
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];

        int low=1; int high=nums.length-2;

        // Answer always exist so array size will always be odd.

        while(low<=high){
            int mid=low+(high-low)/2; //Mid always point to odd

            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            // Element is in right half -> (even,odd);
            else if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])) low=mid+1;
                // Element is in left half -> (odd,even);
            else { // nums[mid]==nums[mid+1]
                high=mid-1;
            }
        }

        return -1;
    }

    static void main(String[] args) {
        int result= singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        System.out.println(result);
    }
}
