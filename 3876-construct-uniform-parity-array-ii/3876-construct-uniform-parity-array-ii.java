class Solution {
    public boolean uniformArray(int[] nums) {
        int smallestOdd = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 1)
                smallestOdd = Math.min(smallestOdd, num);   // All even
        }
        if (smallestOdd == Integer.MAX_VALUE)
            return true;
        for (int num : nums) {
            if (num % 2 == 0 && num <= smallestOdd)  // evey even number ko odd me bana
                return false;
        }

        return true;
    }
}