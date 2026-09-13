class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int [][] result = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int newJ = (j - rowShift[i] + n) % n;

                int newI = (i - colShift[newJ] + n) % n;

                result[newI][newJ] = grid[i][j];
            }
        }
        return result;
    }
}