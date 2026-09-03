class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int maxTrim = 0;
        for (int[] q : queries) {
            maxTrim = Math.max(maxTrim, q[1]);
        }
        List<List<String[]>> l = new ArrayList<>();
        List<String[]> base = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            base.add(new String[]{nums[i], String.valueOf(i)});
        }
        l.add(base);

        for (int i = 1; i <= maxTrim; i++) {
            l.add(countingSort(l.get(i - 1), i));
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            ans[i] = Integer.parseInt(l.get(trim).get(k - 1)[1]);
        }
        return ans;
    }
    private List<String[]> countingSort(List<String[]> lst, int z) {
        int[] counts = new int[10];

        for (String[] elem : lst) {
            int digit = elem[0].charAt(elem[0].length() - z) - '0';
            counts[digit]++;
        }
        int startingIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }
        String[][] sortedArr = new String[lst.size()][2];
        for (String[] elem : lst) {
            int digit = elem[0].charAt(elem[0].length() - z) - '0';
            sortedArr[counts[digit]] = elem;
            counts[digit]++;
        }
        return Arrays.asList(sortedArr);
    }
}
