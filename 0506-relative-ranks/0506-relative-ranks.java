class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        String[] answer = new String[n];
        
        for (int rank = 0; rank < n; rank++) {
            int idx = indices[rank];
            switch (rank) {
                case 0: answer[idx] = "Gold Medal"; break;
                case 1: answer[idx] = "Silver Medal"; break;
                case 2: answer[idx] = "Bronze Medal"; break;
                default: answer[idx] = String.valueOf(rank + 1);
            }
        }
        return answer;
    }
}