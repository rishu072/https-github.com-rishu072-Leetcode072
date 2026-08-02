class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = 0 , c = 0;
        for(int i =0; i<gas.length; i++){
            g += gas[i];
            c += cost[i];
        }
        if(g < c){
            return -1;
        }
        int currGas = 0;
        int st = 0;

        for(int i = 0; i<gas.length; i++){
            currGas += gas[i] - cost[i];
            if(currGas < 0){
                currGas = 0;
                st = i + 1;
            }
        }
        return st;
    }
}