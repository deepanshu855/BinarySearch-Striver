package _Answers;
//Minimize Max Distance to Gas Station

import java.security.KeyPair;
import java.util.PriorityQueue;


public class _12 {
    // This is the brute force TC=O(K x N) + O(N)
    public static double minimiseMaxDistanceBrute(int[] arr, int k) {
        int[] howMany=new int[arr.length-1]; // This will store how many gas station we have placed in iTh interval.

        // Now we'll run a loop to place to k gas station
        for(int gas=1; gas<=k; gas++){
            double maxVal=-1; int maxIdx=-1;
            for(int i=0; i<arr.length-1; i++){
                // Calculate diff
                double diff=arr[i+1]-arr[i];
                // Since we need the difference after placeing gas length;
                double sectionLen=diff/(howMany[i]+1); // (0- interval => arr[1]-arr[0] and so on.)
                // We need to find the maxIdx because we'll add new gas station at maxIdx
                if(maxVal<sectionLen){
                    maxVal=sectionLen;
                    maxIdx=i;
                }
            }
            // We got the maxIdx, hence we'll increment the no of gasStation on it.
            howMany[maxIdx]++;
        }

        double maxAns=-1;
        // Now we have the no. of gas station at each interval, hence we'll find the min(max distance)
        for(int i=0; i<arr.length-1; i++){
            double sectionLen=((double)arr[i+1]-arr[i])/(double)(howMany[i]+1);
            maxAns=Math.max(maxAns,sectionLen);
        }

        return maxAns;
    }

    public static class Pair{
        double sectionLen;
        int index;

        Pair(double sectionLen, int index){
            this.sectionLen=sectionLen;
            this.index=index;
        }
    }

    // This is the better approach. use of priority quesue.
    public static double minimiseMaxDistancePQ(int[] arr, int k){
        PriorityQueue<Pair> pq= new PriorityQueue<>(
                (a, b) -> Double.compare(b.sectionLen, a.sectionLen)
        );
        int[] howMany=new int[arr.length-1];

        // We'll push all the differences into pq.
        for(int i=0; i<arr.length-1; i++){
            pq.offer(new Pair(arr[i+1]-arr[i], i));
        }

        // Now iterate through all new Gas stations
        for(int i=1; i<=k; i++){
            // Remove interval having maximum current section length
            Pair top = pq.poll();

            int idx=top.index;

            // One more gas station added to this interval
            howMany[idx]++;

            // We need to calculate initial difference
            int iniDiff=arr[idx+1]-arr[idx];
            // Updated sectionLen;
            double newSecLen=((double)iniDiff/(double)(howMany[idx]+1));

            pq.offer(new Pair(newSecLen, idx));
        }

        return pq.peek().sectionLen;
    }

    // This is the most optimal solution using binary search
    public static double minimiseMaxDistanceBS(int [] arr, int k){
        double low=0;
        double high=0;
        for(int i=0; i<arr.length-1; i++){
            high=(double)Math.max(arr[i+1]-arr[i], high);
        }

        double ans=-1;

        double diff= 1e-6;
        while(high-low>diff){
            double mid=(low+high)/2.0;

            int cnt=countGasStations(arr,mid);
            if(cnt>k) low=mid;
            else {
                ans=mid;
                high=mid;
            }
        }

        return ans;
    }

    public static int countGasStations(int [] arr, double dist){
        int cnt=0;
        for(int i=0; i<arr.length-1; i++){
            int noInBtwn=(int)((arr[i+1]-arr[i])/dist);
            if((arr[i+1]-arr[i])== noInBtwn*dist){
                noInBtwn--;
            }
            cnt+=noInBtwn;
        }
        return cnt;
    }

    static void main(String[] args) {
        double result= minimiseMaxDistanceBS(new int[]{1, 2, 3, 4, 5, 6 ,7, 8, 9, 10}, 10);
        System.out.println(result);
    }
}
