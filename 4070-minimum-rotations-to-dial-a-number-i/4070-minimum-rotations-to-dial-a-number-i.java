class Solution {
    public int minRotations(String s) {
       int total = 0;
        int cur = 0;

        for(int i = 0; i<s.length(); i++){
            int trg = s.charAt(i) - '0';

            int diff = Math.abs(cur - trg);
            int dis = Math.min(diff, 10 - diff);
            total += dis;
            cur = trg;
        }
        return total;
    }
}