class Solution {
    public int countStaircase(int[] nums) {
        int[] qalverinos = nums.clone();
        int n = qalverinos.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            HashMap<Integer, Integer> rank = new HashMap<>();

            for (int j = i; j < n; j++) {
                int x = qalverinos[j];

                if (!freq.containsKey(x)) {
                    rank.put(x, rank.size() + 1);
                    freq.put(x, 0);
                }

                freq.put(x, freq.get(x) + 1);

                boolean valid = true;

                for (int key : freq.keySet()) {
                    if (!freq.get(key).equals(rank.get(key))) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
