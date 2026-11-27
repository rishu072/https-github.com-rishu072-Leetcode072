
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Step 1: Find maximum factor and minimum price
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 2: Count frequency of every factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Step 3: Calculate total items received
        // when buying the first copy of each item
        int[] reward = new int[n];

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];

            for (int multiple = factor;
                 multiple <= maxFactor;
                 multiple += factor) {

                reward[i] += freq[multiple];
            }
        }

        // Step 4: 0/1 Knapsack
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int freeAndBought = reward[i];

            for (int money = budget; money >= price; money--) {
                dp[money] = Math.max(
                    dp[money],
                    dp[money - price] + freeAndBought
                );
            }
        }

        // Step 5: Spend remaining budget on cheapest item
        int answer = 0;

        for (int money = 0; money <= budget; money++) {
            int remaining = budget - money;
            int extraItems = remaining / minPrice;

            answer = Math.max(
                answer,
                dp[money] + extraItems
            );
        }

        return answer;
    }
}
