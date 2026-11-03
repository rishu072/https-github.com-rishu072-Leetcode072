class Solution {
    public int minMoves(int[] nums) {

        Arrays.sort(nums);
        
        int L = 0;
        int R = nums.length - 1;
        int sum = 0; 
        int mx = nums[R];

        while (L < R){
            sum += mx - nums[L];
            L++;
        }
        return sum;
    }
}