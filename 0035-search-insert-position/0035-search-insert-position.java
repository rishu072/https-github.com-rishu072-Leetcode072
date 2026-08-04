class Solution {
    public int searchInsert(int[] n, int key) {
        int st = 0;
        int end = n.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;

            if (n[mid] == key) { 
                return mid;
            }
            if (n[mid] < key) { 
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return st;

    }
}