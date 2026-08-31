class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        ct, critPts, prev = 0, [], head.val
        while head.next:
            if (prev - head.val) * (head.val - head.next.val) < 0:
                critPts.append(ct)
            prev, head = head.val, head.next
            ct += 1

        n = len(critPts)
        if n < 2: 
            return [-1, -1]

        mn = min((critPts[i] - critPts[i - 1] for i in range(1, n)))
        mx = critPts[-1] - critPts[0]

        return [mn, mx]
