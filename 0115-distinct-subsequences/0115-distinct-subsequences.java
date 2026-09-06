class Solution {
    public int numDistinct(String s, String t) {
        int m  = s.length();
        int n = t.length();

        if(m < n){
            return 0;
        }
        int []DP = new int[n + 1];
        DP[n] = 1;

        for(int i = m - 1; i >= 0; i--){
            char sChar = s.charAt(i);
            for(int j = 0; j<n; j++){
                char tChar = t.charAt(j);
                if (sChar == tChar){
                    DP[j] = DP[j + 1] + DP[j];
                }
            }
        }
        return DP[0];
    }
}