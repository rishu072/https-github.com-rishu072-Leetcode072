class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long winsum = 0;
        long mx_ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            winsum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            mx_ans = winsum;
        }

        for (int j = k; j < nums.length; j++) {

            // Add incoming element
            winsum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Remove outgoing element
            winsum -= nums[j - k];

            map.put(nums[j - k], map.get(nums[j - k]) - 1);
            // Remove element if frequency becomes zero
            if (map.get(nums[j - k]) == 0) {
                map.remove(nums[j - k]);
            }
            // Check distinct elements
            if (map.size() == k) {
                mx_ans = Math.max(mx_ans, winsum);
            }
        }
        return mx_ans;
    }
}