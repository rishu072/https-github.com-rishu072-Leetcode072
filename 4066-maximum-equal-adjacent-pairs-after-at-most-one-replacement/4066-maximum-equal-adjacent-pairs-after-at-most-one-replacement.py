class Solution(object):
    def maxEqualAdjacentPairs(self, nums):
        n=len(nums)
        ans=0
        gain={}
        for i in range(n-1):
            a=nums[i]
            b=nums[i+1]
            if a==b:
                ans+=1
            else:
                if a not in gain:
                    gain[a]={}
                if b not in gain[a]:
                    gain[a][b]=0
                gain[a][b]+=1
        best=0
        for x in gain:
            for y in gain[x]:
                value=gain[x][y]
                if y in gain and x in gain[y]:
                    value+=gain[y][x]
                best=max(best,value)
        return ans+best