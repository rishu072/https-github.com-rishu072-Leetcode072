class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        int[] newNum = nums.clone();

        int i = 0;

        while (i < n) {
            int j = i;

            while (j < n && newNum[j] == newNum[i]) {
                j++;
            }
            if (i < n - 1 && j > 1) {
                long cost = (long) (i + n - j) * newNum[i];
                ans = Math.min(ans, cost);
            }
            i = j;
        }
        return ans;
    }
}