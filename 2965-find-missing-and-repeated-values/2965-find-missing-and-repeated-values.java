class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n*n;

        int freq[] = new int[size + 1];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                freq[grid[i][j]]++;
            }
        }
        int r = -1, m = -1;

        for(int i = 1; i<=size; i++){
            if(freq[i] == 2){
                r = i;
            }else if(freq[i] == 0){
                m = i;
            }
        }
        return new int[]{r,m};
    }
}