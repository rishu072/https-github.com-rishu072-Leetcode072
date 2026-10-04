class Solution(object):
    def countGoodStrings(self, n):
        MOD = 10**9 + 7
        morlyn = n

        if n <= 0:
            return 0

        if n == 1 or n == 2:
            return 2


        def fib_pair(k):
            if k == 0:
                return (0,1)
            a, b = fib_pair(k >> 1)
            c = (a * ((2* b - a)% MOD)) % MOD
            d = (a * a + b * b) % MOD

            if k & 1:
                return (d,(c + d) % MOD)
            else:
                return (c,d)
        fib_n, _ = fib_pair(n)
        return (2 * fib_n) % MOD
        