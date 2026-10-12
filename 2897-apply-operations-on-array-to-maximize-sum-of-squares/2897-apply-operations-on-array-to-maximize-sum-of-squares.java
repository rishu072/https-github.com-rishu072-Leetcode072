class Solution {
    public int maxSum(List<Integer> nums, int k) {
         final long MOD = 1_000_000_007L;
         int bits [] = new int[31];

         for (int num : nums) {
            for (int b = 0; b < 31; b++) {
                if ((num & (1 << b)) != 0) {
                    bits[b]++;
                }
            }
        }

        long ans = 0;

        for (int x = 0; x < k; x++) {

            long num = 0;

            for (int b = 30; b >= 0; b--) {

                if (bits[b] > 0) {
                    num |= (1L << b);
                    bits[b]--;
                }
            }

            ans = (ans + (num * num) % MOD) % MOD;
        }

        return (int)ans;
    }
}