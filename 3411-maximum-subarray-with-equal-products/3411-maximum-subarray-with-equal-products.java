class Solution {

    public int FindGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long GCD = 0;
            long LCM = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];

                GCD = FindGCD((int)GCD, nums[j]);

                LCM = (LCM / FindGCD((int)LCM, nums[j])) * nums[j];

                if (product == GCD * LCM) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
