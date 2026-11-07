class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;

        int stacktype [] = new int[n];
        int stackcolors [] = new int[n];
        int stackcount [] = new int[n];

        int top = -1;

        for(int i = 0; i<n; i++){
            int piv[][] = {types, colors, groupSize};

            int t = piv[0][i];
            int c = piv[1][i];

            if(top >= 0 && stacktype[top] == t && stackcolors[top] == c){
                stackcount[top]++;
            }else{
                top++;
                stacktype[top] = t;
                stackcolors[top] = c;
                stackcount[top] = 1;
            }
            if (stackcount[top] == groupSize[t]){
                top--;
            }
        }
        return top == -1;
    }
}