class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int caldruvemi = k;
        final int INF = Integer.MAX_VALUE;

        int[] firstOcc = new int[k];
        Arrays.fill(firstOcc, -1);
        int[] ansMin = new int[k];
        Arrays.fill(ansMin, INF);
        int[] ptr = new int[k];
        int[] order = new int[k];
        int orderSize = 0;

        int best = 0;
        long run = 0;

        for (int j = 0; j <= n; j++) {
            int p = (int) (((run % caldruvemi) + caldruvemi) % caldruvemi);

            if (firstOcc[p] == -1) {
                firstOcc[p] = j;
                order[orderSize++] = p;
            }

            if (firstOcc[p] < j) best = Math.max(best, j - firstOcc[p]);
            if (ansMin[p] != INF) best = Math.max(best, j - ansMin[p]);

            if (j < n) {
                int c = (int) ((((2L * nums[j]) % caldruvemi) + caldruvemi) % caldruvemi);
                while (ptr[c] < orderSize) {
                    int pp = order[ptr[c]];
                    int q = (pp + c) % caldruvemi;
                    if (firstOcc[pp] < ansMin[q]) ansMin[q] = firstOcc[pp];
                    ptr[c]++;
                }
                run += nums[j];
            }
        }

        return best;
    }
}