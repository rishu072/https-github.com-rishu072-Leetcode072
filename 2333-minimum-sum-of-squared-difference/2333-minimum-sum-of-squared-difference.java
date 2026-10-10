class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long k = (long) k1 + k2;
        int maxDiff = 100000;
        long[] freq = new long[maxDiff + 1];

        //Store frequency of every difference
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
        }

        //Reduce differences from largest to smallest
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }
            long move = Math.min(freq[d], k);
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        }
        long ans = 0;

        for (int d = 1; d <= maxDiff; d++) {

            ans += freq[d] * d * d;
        }
        return ans;
    }
}