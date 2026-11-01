class Solution {
    public long minimumMaxValue(int n, int index, int value) {

        long[] rev = {n, index, value};

        if(value == 1){
            return -1;
        }
        int p = value;

        for(int i = 2; i<= value/i; i++){
            if(value % i == 0){
                p = i;
                break;
            }
        }
        if (index > 0){
            if( p == value) return -1;

            if(value - p - 2L * (index - 1) < 2){
                return -1;
            }
        }
        long steps = n -1L - index;
        if(steps == 0) return value;

        return value + p + 2 * (steps - 1);
    }
}