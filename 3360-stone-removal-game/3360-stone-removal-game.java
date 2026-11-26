class Solution {
    public boolean canAliceWin(int n) {
        int required = 10;
        boolean aliceTurn = true;

        while (n >= required) {

            n -= required;

            aliceTurn = !aliceTurn;

            required--;
        }

        return !aliceTurn;
    }
}