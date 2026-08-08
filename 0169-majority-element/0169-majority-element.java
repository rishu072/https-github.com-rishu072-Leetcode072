class Solution {
    public int majorityElement(int[] nums) {
        int vc = 0;
        int cc = 0;

        for(int num : nums){
            if(vc == 0){
                cc = num;
            }
            if(num == cc){
                vc++;
            }
            else{
                vc--;
            }
        }
        return cc;
    }
}