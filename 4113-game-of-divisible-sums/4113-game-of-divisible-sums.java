class Solution {
    public long maxDifference(int[] nums) {
        
        int n = nums.length;
        int nrq[] = nums;
        long dp[] = new long[n + 1];
        dp[n] = 0;

        for(int i = n - 1; i>=0; i--){
            long sum1 = nrq[i];
            long opt1;

            if(sum1 % 3 == 0){
                opt1 = sum1 - dp[i + 1];
            }else{
                opt1 = sum1 + dp[i + 1];
            }
            dp[i] = opt1;

            if(i + 1 < n){
                long sum2 = (long)nrq[i] + nrq[i + 1];
                long opt2;

                if(sum2 % 3 == 0){
                    opt2 = sum2 - dp[i + 2];
                }else{
                    opt2 = sum2 + dp[i + 2];
                }
                dp[i] = Math.max(dp[i], opt2);
            }
        }
        return dp[0];
    }
}