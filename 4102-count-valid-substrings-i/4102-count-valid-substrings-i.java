class Solution {
    public long countValidSubstrings(String s) {

        int left = -1;
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i >= 2 &&
                s.charAt(i - 2) == 'a' &&
                s.charAt(i - 1) == 'b' &&
                s.charAt(i) == 'c') {

                left = i - 2;
            }

            ans += i - left;
        }

        return ans;
    }
}