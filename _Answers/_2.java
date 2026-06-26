package _Answers;
//Find Nth root of a number

public class _2 {
    // This is brute force method
    public static int NthRootBrute(int N, int M) {
        if(M==1) return 1;

        for(int i=1; i<=M; i++){
            long mul=1;
            for(int j=1; j<=N; j++){
                mul*=i;
            }
            if(mul==M) return i;
            if(mul>M) break;
        }

        return -1;
    }

    public int NthRoot(int N, int M) {
        if(M==1) return 1;

        int low=1; int high=M;

        while(low<=high){
            int mid=low+(high-low)/2;
            long val=1;
            // Calculate value.
            for(int i=1; i<=N; i++){
                val*=mid;
                // This edge case handles the overflow case.
                if(val>M){
                    break;
                }
            }

            if(val==M) return mid;
            else if(val<M) low=mid+1;
            else high=mid-1;
        }

        return -1;
    }

    static void main(String[] args) {
        int result= NthRootBrute(3,27);
        System.out.println(result);
    }
}
