class Solution(object):
    def maxAlternatingSum(self, nums):

        ver = nums
        n = len(nums)
        NEG  = float('-inf')

        prev = [[NEG,NEG],[NEG, NEG]]

        ans = NEG

        for i in range(n):
            cur = [[NEG, NEG],[NEG,NEG]]
            cur[0][0] = max(cur[0][0], nums[i])

            if i > 0:

                for d in range(2):
                    for p in range(2):
                        if prev[d][p] == NEG:
                            continue
                        new_p = (p + 1) % 2
                        val = prev[d][p] + (nums[i] if new_p == 0 else -nums[i])
                        cur[d][new_p] = max(cur[d][new_p],val)

                for p in range(2):
                    if prev[0][p] == NEG:
                        continue
                    cur[1][p] = max(cur[1][p],prev[0][p])

            for d in range(2):
                for p in range(2):
                    if cur[d][p] != NEG:
                        ans = max(ans, cur[d][p])
            prev = cur
        return ans