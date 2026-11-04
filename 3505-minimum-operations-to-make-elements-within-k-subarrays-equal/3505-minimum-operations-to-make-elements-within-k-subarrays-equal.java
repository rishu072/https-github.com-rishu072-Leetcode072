class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] ops = new long[n];
        long sumL = 0, sumR = 0;
        int sizeL = 0, sizeR = 0;
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        Map<Integer, Integer> delayed = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (left.isEmpty() || val <= left.peek()) {
                left.offer(val); sumL += val; sizeL++;
            } else {
                right.offer(val); sumR += val; sizeR++;
            }

            if (i >= x) {
                int rem = nums[i - x];
                delayed.put(rem, delayed.getOrDefault(rem, 0) + 1);
                if (rem <= left.peek()) {
                    sizeL--; sumL -= rem;
                    if (rem == left.peek()) prune(left, delayed);
                } else {
                    sizeR--; sumR -= rem;
                    if (rem == right.peek()) prune(right, delayed);
                }
            }

            while (sizeL > sizeR + 1) {
                int move = left.poll();
                right.offer(move);
                sumL -= move; sumR += move;
                sizeL--; sizeR++;
                prune(left, delayed);
            }
            while (sizeR > sizeL) {
                int move = right.poll();
                left.offer(move);
                sumR -= move; sumL += move;
                sizeR--; sizeL++;
                prune(right, delayed);
            }

            if (i >= x - 1) {
                long mid = left.peek();
                ops[i] = mid * sizeL - sumL + sumR - mid * sizeR;
            }
        }

        long[] pre = new long[n + 1];
        long[] cur = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            Arrays.fill(cur, Long.MAX_VALUE / 2);
            for (int i = j * x - 1; i < n; i++) {
                cur[i + 1] = Math.min(cur[i], pre[i - x + 1] + ops[i]);
            }
            long[] temp = pre; pre = cur; cur = temp;
        }
        return pre[n];
    }
    
    private void prune(PriorityQueue<Integer> pq, Map<Integer, Integer> delayed) {
        while (!pq.isEmpty() && delayed.getOrDefault(pq.peek(), 0) > 0) {
            delayed.put(pq.peek(), delayed.get(pq.peek()) - 1);
            pq.poll();
        }
    }
}