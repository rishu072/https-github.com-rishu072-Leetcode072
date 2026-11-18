class Solution {
    public int minChanges(String s) {
        int ans = 0;
        int i = 0;
        int j = 1;

        while(j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                ans++;
            }
            i += 2;
            j += 2;
        }
        return ans;
    }
}