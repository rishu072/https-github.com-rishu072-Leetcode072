class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        long count = 0;
        
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int k = 0;
        for(int i = 0; i < n; i++){
            while(start[i] > end[k]){
                k++;
            }
            count += i - k;
        }

        return count;
    }
}