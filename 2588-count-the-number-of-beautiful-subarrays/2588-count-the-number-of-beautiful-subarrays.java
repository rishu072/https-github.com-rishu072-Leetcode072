class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);

        int presum = 0;
        long count = 0;

        for(int x : nums){
            presum ^= x;

            int y = map.getOrDefault(presum, 0);
            count += y;

            map.put(presum, y+1);
        }
        return count;
    }
}