class Solution {
    public int minRange(int a, int b, int c) {
        int n[] =  {a,b,c};
        int max = Math.max(a,Math.max(b,c));
        int min = Math.min(a,Math.min(b,c));

        int range = max - min;
        int nums[] = {a,b,c};

        for(int i = 0; i<3; i++){
            int x = nums[(i + 1)%3];
            int y = nums[(i + 2)%3];

            int newValue = x + y;

            int newMax = Math.max(newValue,Math.max(x,y));
            int newMin = Math.min(newValue,Math.min(x,y));

            range = Math.min(range, newMax - newMin);
        }
        return range;
    }
}