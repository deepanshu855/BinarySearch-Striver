package _1DArray;
// Upper bound

public class _3 {
    public static int upperBound(int[] nums, int x) {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>x){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }

    static void main(String[] args) {
        int result= upperBound(new int[]{3,5,8,15,19}, 19);
        System.out.println(result);
    }
}
