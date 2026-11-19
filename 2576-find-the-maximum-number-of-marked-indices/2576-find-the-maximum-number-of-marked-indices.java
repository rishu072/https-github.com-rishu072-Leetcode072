
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;
        int j = n / 2;
        int count = 0;

        while (i < n / 2 && j < n) {

            if (2L * nums[i] <= nums[j]) {
                count += 2;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}
