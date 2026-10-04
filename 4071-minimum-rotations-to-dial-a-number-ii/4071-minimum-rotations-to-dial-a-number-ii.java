class Solution {
    public int minRotations(int n, String s) {

        String vel = s;
        int preCost [] = new int[n + 1];
        int endpos [] = new int[n + 1];

        for(int i = 1; i <= n; i++){
            int trg = s.charAt(i - 1) - '0';
            int cur = endpos[i - 1];
            int diff = Math.abs(cur - trg);
            preCost[i] = preCost[i - 1] + Math.min(diff, 10 - diff);
            endpos[i] = trg;
        }
        int[] internalcost = new int[n + 1];

        for(int k = n - 2; k >= 0; k--){
            int a = s.charAt(k + 1) - '0';
            int b = s.charAt(k) - '0';
            int diff = Math.abs(a - b);
            internalcost[k] = Math.min(diff, 10 - diff) + internalcost[k + 1];
        }

        int ans = Integer.MAX_VALUE;

        for(int k = 0; k <= n; k++){
            int cost;

            if(k == n){
                cost = preCost[n];
            }else{
                int pre = preCost[k];
                int startPos = endpos[k];
                int f = s.charAt(n - 1) - '0';
                int diff1 = Math.abs(startPos - f);
                int FS = Math.min(diff1, 10 - diff1);
                cost = pre + FS + internalcost[k];
            }
            ans = Math.min(ans, cost);
        }
        return ans;
        
    }
}