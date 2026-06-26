package _Answers;
// Split array largest sum

public class _10 {
    // Brute force
    public static int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0; i<nums.length; i++){
            max=Math.max(nums[i],max);
            sum+=nums[i];
        }

        for(int i=max; i<=sum; i++){
            int subArrays= splitSum(nums,k,i);
            if(subArrays<=k) return i;
        }

        return -1;
    }

    public static int splitSum(int[] nums, int k, int threshold){
        long sum=0; int cnt=1;

        for(int i=0; i<nums.length; i++){
            if(nums[i]+sum>threshold){
                cnt++;
                sum=nums[i];
            } else {
                sum+=nums[i];
            }
        }

        return cnt;
    }
}
