class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);

        int L = 0;
        int R = nums.length - 1;

        int ans = 0;

        while( L < R){
            ans += nums[R] - nums[L]; 
            L++;
            R--;
        }
        return ans;
    }
}