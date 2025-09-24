import heapq 
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        heap = [-num for num in nums]
        heapq.heapify(heap)
        for i in range(k-1):
            heapq.heappop(heap)
        return -heapq.heappop(heap)
