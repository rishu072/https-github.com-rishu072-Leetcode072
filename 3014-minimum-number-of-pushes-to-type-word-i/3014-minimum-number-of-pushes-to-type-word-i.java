class Solution {
    public int minimumPushes(String word) {
        int g = 0;
        for(int i = 0; i<word.length(); i++){

            g += i/8+1;
        }
        return g;
    }
}