class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        int offset = -min;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += offset;
        }
        max += offset;
        
        int exp = 1;
        int n = nums.length;
        int[] output = new int[n];
        
        while (max / exp > 0) {
            int[] count = new int[10];
            for (int i = 0; i < n; i++) {
                count[(nums[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                output[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = output[i];
            }
            exp *= 10;
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] -= offset;
        }
        return nums;
    }
}