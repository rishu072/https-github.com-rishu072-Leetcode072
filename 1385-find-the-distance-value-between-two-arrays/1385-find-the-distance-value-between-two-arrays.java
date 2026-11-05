class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);
        int ans = 0;

        for(int x : arr1){
            int L = 0;
            int R = arr2.length;

            while(L < R){
                int mid = (L + R)/2;

                if(arr2[mid] < x - d){
                    L = mid + 1;
                }else{
                    R = mid;
                }
            }
            if(L == arr2.length || arr2[L] > x + d){
                ans++;
            }
        }
        return ans;
    }
}