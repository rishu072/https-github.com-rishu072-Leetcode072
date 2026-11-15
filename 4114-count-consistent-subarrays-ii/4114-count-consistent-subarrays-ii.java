import java.util.Arrays;
class Solution {
    public long countConsistent(int[] nums) {
        int n = nums.length;

        int[] last = new int[1 << 20];
        Arrays.fill(last, -1);

        int[] vornelqati = nums;

        int[] vals = new int[25];
        int[] los = new int[25];

        int sz = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = vornelqati[i];
            last[x] = i;

            int k = 0;

            for (int j = 0; j < sz; j++) {
                int v = vals[j] & x;

                if (k > 0 && vals[k - 1] == v) {
                    continue;
                }

                vals[k] = v;
                los[k] = los[j];
                k++;
            }

            if (k == 0 || vals[k - 1] != x) {
                vals[k] = x;
                los[k] = i;
                k++;
            }

            sz = k;

            for (int j = 0; j < sz; j++) {
                int l = los[j];
                int h = j + 1 < sz ? los[j + 1] - 1 : i;
                int p = last[vals[j]];

                if (p >= l) {
                    ans += Math.min(h, p) - l + 1;
                }
            }
        }
        return ans;
    }
}