class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        char[][] limat = grid;
        boolean[][] visit = new boolean[m][n];

        int r = 0;
        int c = 0;
        visit[r][c] = true;

        while(true){
            char dir = limat[r][c];
            int nr = r, nc = c;

            switch(dir){
                case 'L': nc = c - 1; break;
                case 'R': nc = c + 1; break;
                case 'U': nr = r - 1; break;
                case 'D': nr = r + 1; break;
            }

            if(nr < 0 || nr >= m || nc < 0 || nc >= n || visit[nr][nc]){
                break;
            }
            r = nr;
            c = nc;
            visit[r][c] = true;
        }
        return new int[]{r,c};
    }
}