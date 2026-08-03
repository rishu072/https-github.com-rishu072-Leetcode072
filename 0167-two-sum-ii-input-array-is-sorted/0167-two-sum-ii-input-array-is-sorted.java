class Solution {
    public int[] twoSum(int[] num, int target) {
        int st = 0;
        int end = num.length - 1;

        while(st < end){
            int sum = num[st] + num[end];

            if(sum == target){
                return new int[]{st+1,end+1};
            }
            else if(sum < target){
                st++;
            }
            else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }
}