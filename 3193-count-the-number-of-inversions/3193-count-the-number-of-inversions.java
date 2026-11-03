
import java.util.*;

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {

        int MOD = 1_000_000_007;

        int maxInv = n * (n - 1) / 2;

        // Store requirements
        int[] required = new int[n];
        Arrays.fill(required, -1);

        for (int[] r : requirements) {
            required[r[0]] = r[1];
        }

        // Initialize DP
        int[] prev = new int[maxInv + 1];
        prev[0] = 1;

        //  Build DP for every prefix
        for (int i = 1; i <= n; i++) {

            int[] curr = new int[maxInv + 1];

            long window = 0;

            int currentMax = i * (i - 1) / 2;

            // Sliding window optimization
            for (int j = 0; j <= currentMax; j++) {

                window += prev[j];

                if (j >= i) {
                    window -= prev[j - i];
                }

                window %= MOD;

                if (window < 0) {
                    window += MOD;
                }

                curr[j] = (int) window;
            }

            // Apply prefix requirement
            int need = required[i - 1];

            if (need != -1) {

                if (need > currentMax) {
                    return 0;
                }

                int ways = curr[need];

                Arrays.fill(curr, 0);
                curr[need] = ways;
            }

            prev = curr;
        }

        // Return final answer
        long ans = 0;

        for (int ways : prev) {
            ans = (ans + ways) % MOD;
        }

        return (int) ans;
    }
}
