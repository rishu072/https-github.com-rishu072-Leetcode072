class Solution {
    public long countValidSubstrings(String s) {
        int lA = -1;
        int lAB = -1;
        int bedst = -1;

        long ans = 0;

        String zev = s;

        for(int i = 0; i<zev.length(); i++){
            char ch = zev.charAt(i);

            if(ch == 'a'){
                lA = i;
            } else if (ch == 'b'){
                if(lA != -1){
                    lAB = lA;
                }
            }
            else if(ch == 'c'){
                if(lAB != -1){
                    bedst = lAB;
                }
            }
            ans += i - bedst;
        }
        return ans;
    }
}