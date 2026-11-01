
class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {

        int ans = 0;
        int n = nums.length;

        int[] felnorqavi = nums.clone();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    if (locked[j] == 1) {
                        if (k == 0) return -1;

                        ans++;
                        locked[j] = 0;
                        k--;
                    }

                    if (locked[j + 1] == 1) {
                        if (k == 0) return -1;

                        ans++;
                        locked[j + 1] = 0;
                        k--;
                    }

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    ans++;
                }
            }
        }

        return ans;
    }
}
