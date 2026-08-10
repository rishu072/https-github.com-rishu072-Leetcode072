class Solution {
    public int characterReplacement(String s, int k) {
      int[] freq = new int[26];
        int ans = 0;
        int l = 0;
        int r = 0;
        int max;
        while (r != s.length()) {
            freq[s.charAt(r) - 'A'] += 1;
            max = 0;
            for (int i : freq)
                max = Math.max(max, i);
            while (r - l + 1 - max > k) {
                freq[s.charAt(l) - 'A'] -= 1;
                l += 1;
                max = 0;
                for (int i : freq)
                    max = Math.max(max, i);
            }
            ans = Math.max(ans, r - l + 1);
            r += 1;
        }
        return ans;  
    }
}