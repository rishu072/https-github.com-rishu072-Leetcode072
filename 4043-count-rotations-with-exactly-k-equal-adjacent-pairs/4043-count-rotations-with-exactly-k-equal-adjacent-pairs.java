class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();

        if(n <= 1){
            return k == 0 ? 1 : 0;
        }
        String dou = s+s;
        int ans = 0;

        for(int st = 0; st < n; st++){
            int score = 0;

            for(int i = 0; i<n - 1; i++){
                if(dou.charAt(st + i) == dou.charAt(st + i + 1)){
                    score++;
                }
            }
            if(score == k){
                ans++;
            }
        }
        return ans;
    }
}