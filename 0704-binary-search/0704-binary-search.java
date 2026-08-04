class Solution {
    public int search(int[] nums, int key) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;

            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) { 
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}