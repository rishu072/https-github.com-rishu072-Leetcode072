class Solution {
    public int minDeletions(int[] nums) {
        if(nums.length == 0) return 0;

        int  delete = 0;
        int last = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] == last){
                delete++;
            }else{
                last = nums[i];
            }
        }
        return delete;
    }
}