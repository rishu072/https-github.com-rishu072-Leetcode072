
class Solution {
    public int minOperations(String s) {

        int n = s.length();
        boolean isSorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }

        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            minChar = (char) Math.min(minChar, c);
            maxChar = (char) Math.max(maxChar, c);
        }

        if (s.charAt(0) == minChar ||
            s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == minChar ||
                s.charAt(i) == maxChar) {
                return 2;
            }
        }
        return 3;
    }
}
