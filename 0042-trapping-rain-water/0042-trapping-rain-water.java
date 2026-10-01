class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int res = 0;
        int l = 0;
        int r = n - 1;
        int rMax = h[r];
        int lMax = h[l];

        while ( l < r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(lMax, h[l]);
                res += lMax - h[l];
            }else{
                r--;
                rMax = Math.max(rMax, h[r]);
                res += rMax - h[r];
            }
        }
        return res;
    }
}