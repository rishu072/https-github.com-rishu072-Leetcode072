class Solution {
    public int countSuffix(int[] nums, int[] targ) {

        int n = nums.length;
        int ans = 0;

        int val[] = nums;

        int p = 0;
        while(p < n && nums[p] == targ[p]) p++;

        boolean non[] = new boolean[n];
        non[n - 1] = true;

        
        for (int i = n-2; i >= 0; i--)
            non[i] = non[i+1] && (targ[i] >= targ[i+1]);

        int[] freq = new int[100001];
        int b = 0;
        
        for (int i = n-1; i >= 0; i--) {
            b = update(freq, nums[i], -1, b);
            b = update(freq, targ[i], +1, b);
            if (i <= p && non[i] && b == 0) ans++;
        }
        return ans;    
    }
    private int update(int[] freq, int v, int del, int b) {
        if (freq[v] == 0) b++;
        freq[v] += del;
        if (freq[v] == 0) b--;
        return b;
    }
}