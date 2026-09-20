class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
       int n = intervals.length;
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = i + 1; j < n; j++){

                if(intersects(intervals[i],intervals[j])){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean intersects(int[] a, int[] b){
        return Math.max(a[0],b[0]) <= Math.min(a[1],b[1]);
    }
}