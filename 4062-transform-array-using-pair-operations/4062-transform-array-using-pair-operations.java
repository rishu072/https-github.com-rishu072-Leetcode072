class Solution {
    public boolean canTransform(int[] source, int[] target) {
        int [] s = source;
        int n = source.length;

        if (n == 1){
            return source[0] == target[0];
        }
        long sumsour = 0, sumTar = 0;
        for(int x : source) sumsour += x;
        for(int x : target) sumTar += x;

        return sumsour == sumTar;
    }
}