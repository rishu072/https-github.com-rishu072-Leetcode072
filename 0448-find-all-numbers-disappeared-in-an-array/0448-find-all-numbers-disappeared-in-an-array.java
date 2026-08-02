class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int expected = 1;
        int i = 0;

        while (expected <= nums.length) {

            while (i < nums.length && nums[i] < expected) {
                i++;
            }

            if (i < nums.length && nums[i] == expected) {
                expected++;
                i++;
            } else {
                ans.add(expected);
                expected++;
            }
        }

        return ans;
    }
}