package _1DArray;
// Binary Search

public class _1 {
    public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]<target) start=mid+1;
            else if(nums[mid]>target) end=mid-1;
            else return mid;
        }

        return -1;
    }

    static void main(String[] args) {
        int idx= search(new int[]{1,0,3,5,9,12},4);
        System.out.println(idx);
    }
}
