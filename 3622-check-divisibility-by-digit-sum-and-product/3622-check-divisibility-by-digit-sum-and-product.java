class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0;
        int p = 1;

        String str = String.valueOf(Math.abs(n));

        for (char ch : str.toCharArray()) {
            int d = ch - '0';
            s += d;
            p *= d;
        }

        if (n % (s + p) == 0) {
            return true;
        } else {
            return false;
        }
    }
}