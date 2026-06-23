package _1DArray;
// Count Occurrences in a Sorted Array

public class _7 {
    public static int countOccurrences(int[] arr, int target) {
        int first=lowerBound(arr,target);
        int last=upperBound(arr,target);

        return (last-first);
    }

    public static int lowerBound(int[] arr, int target){
        int low=0; int high=arr.length-1;
        int ans=arr.length;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(arr[mid]>=target) {
                ans=mid;
                high=mid-1;
            } else {
                low=low+1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] arr, int target){
        int low=0; int high=arr.length-1;
        int ans=arr.length;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(arr[mid]>target) {
                ans=mid;
                high=mid-1;
            } else {
                low=low+1;
            }
        }

        return ans;
    }

    static void main(String[] args) {
        int result= countOccurrences(new int[]{0, 0, 1, 1, 1, 2, 3},1);
        System.out.println(result);
    }
}
