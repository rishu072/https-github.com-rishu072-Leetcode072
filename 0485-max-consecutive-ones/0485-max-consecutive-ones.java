class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mx_count = 0;
        int curr_count = 0;
        int n = nums.length;

        for(int j = 0; j < n; j++){
            if(nums[j] == 1){
                curr_count++;

            }
            else{
                mx_count = Math.max(mx_count,curr_count);
                curr_count = 0;
            }
        }
        return Math.max(mx_count,curr_count);
    }
}