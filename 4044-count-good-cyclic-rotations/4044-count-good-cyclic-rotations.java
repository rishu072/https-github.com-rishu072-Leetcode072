class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n/2;

        int [] peld = nums;

        long total = 0;
        for(int num : nums){
            total += num;
        }
        long firstSum = 0;
        for(int i = 0; i<half; i++){
            firstSum += nums[i];
        }

        int count = 0;

        for(int i = 0; i<n; i++){
            long secSum = total - firstSum;

            if(firstSum > secSum){
                count++;
            }

            firstSum = firstSum - nums[i] + nums[(i + half) % n];
        }
        return count;
    }
}