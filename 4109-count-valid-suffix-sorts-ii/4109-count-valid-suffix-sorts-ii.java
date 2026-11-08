class Solution {
    public int[] countSuffix(int[] nums, int[] target) {

        int n = nums.length;
        int m = target.length;

        int ans[] = new int[m - n + 1];
        int N[][] = {nums,target};

        int com[] = new int[n + 1 + m];

        for(int i = 0; i<n; i++){
            com[i] = nums[i];
        }
        com[n] = 0;

        for(int i = 0; i<m; i++){
            com[n + 1 + i] = target[i];
        }
        int z[] = new int[com.length];

        int L = 0;
        int R = 0;

        for(int i = 1; i<com.length; i++){
            if(i <= R){
                z[i] = Math.min(R - i + 1, z[i - L]);
            }
            while (i + z[i] < com.length && com[z[i]] == com[i + z[i]]){
                z[i]++;
            }
            if(i + z[i] - 1> R){
                L = i;
                R = i + z[i] - 1;
            }
        }
        
        int pre[] = new int[m];
        pre[0] = 0;
        for(int i = 1; i < m; i++){
            
        pre[i] = (target[i-1] >= target[i]) ? pre[i-1] : i;
            
        }
        
        int freq[] = new int[100001];
        int b = 0;

        for(int x : nums){
            b = update(freq, x, -1, b);
        }
        for(int i = 0; i<n; i++){
            b = update(freq, target[i], 1, b);
        }
        for(int k = 0; k <= m - n; k++){
            if(b == 0){
                int right = k + n - 1;
                int minI = Math.max(0, pre[right] - k);   
                int maxI = Math.min(n - 1, z[n + 1 + k]);
                if(maxI >= minI){
                    ans[k] = maxI - minI + 1;
                }
            }
            if(k < m - n){
                b = update(freq, target[k], -1,b);
                b = update(freq, target[k + n], 1,b);
            }
        }
        return ans;
    }
    private int update(int freq[], int value, int del, int b){
        if(freq[value] == 0){
            b++;
        }
        freq[value] += del;
        if(freq[value] == 0){
            b--;
        }
        return b;
    }
}