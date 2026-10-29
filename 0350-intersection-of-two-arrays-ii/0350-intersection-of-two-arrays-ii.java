class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                result[k++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        return Arrays.copyOf(result, k);
    }
}