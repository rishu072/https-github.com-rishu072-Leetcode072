class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        
        int a = -1;  
        int b = n; 
        
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'a') {
                a = Math.max(a, i);
            } else {
                b = Math.min(b, i);
            }
        }
        return a < b;
    }
}