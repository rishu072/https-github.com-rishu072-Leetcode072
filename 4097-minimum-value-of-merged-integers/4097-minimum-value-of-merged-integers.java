class Solution {
    public int minMergedInteger(int[] nums) {
        
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i += 2){
            int sec = nums[i + 1];

            int digits = String.valueOf(sec).length();
            int merg = nums[i] * (int)Math.pow(10, digits) + sec;
            min = Math.min(min, merg);
        }
        return min;
    }
}