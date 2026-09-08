class Solution {
    public int countCommas(int n) {
        int r = 0;
        for(int i = 1; i<=n; ++i){
            if(i>999){
                r += 1;
            }
        }
        return r;
    }
}