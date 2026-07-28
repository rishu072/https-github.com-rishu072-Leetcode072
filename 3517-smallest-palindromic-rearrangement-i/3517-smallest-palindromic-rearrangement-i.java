class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] bucket = new int[26];
        for (int i = 0; i < n / 2; i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                left.append((char)('a' + i));
            }
        }
        String mid = n % 2 != 0 ? String.valueOf(s.charAt(n / 2)) : "";
        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }
}