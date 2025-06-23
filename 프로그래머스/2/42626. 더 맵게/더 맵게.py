import heapq

def check_scoville(arr, K):
    if arr[0] >= K:
        return True
    return False

def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0
    
    while(len(scoville) > 1):
        if check_scoville(scoville, K):
            return count
        
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        
        value = first + second * 2
        
        heapq.heappush(scoville, value)
        
        count += 1
    
    if check_scoville(scoville, K):
        return count
    
    return -1