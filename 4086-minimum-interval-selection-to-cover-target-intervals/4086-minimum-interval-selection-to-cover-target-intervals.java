class Solution {
    public int minSelection(int[][] a, int[][] t) {
        int n = a.length, m = t.length;
        
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        Arrays.sort(t, (x, y) -> Integer.compare(x[0], y[0]));
        
        int i = 0, j = 0, maxi = -1, ans = 0;
        int cur = t[0][0];
        
        while (j < m) {
            int pmax = maxi;
            while (i < n && a[i][0] <= cur) {
                maxi = Math.max(maxi, a[i][1]);
                i++;
            }
            
            if (pmax == maxi) return -1;
            ans++;
            
            while (j < m && t[j][1] <= maxi) j++;
            
            if (j == m) return ans;
            
            if (maxi < t[j][0]) cur = t[j][0];
            else cur = maxi;
        }
        
        return ans;
    }
}