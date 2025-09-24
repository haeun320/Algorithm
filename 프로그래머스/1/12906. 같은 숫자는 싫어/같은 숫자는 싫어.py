from collections import deque

def solution(arr):
    q = deque(arr)
    n = q.popleft()
    answer = [n]
    
    while q:
        v = q.popleft()
        if n == v:
            continue
        answer.append(v)
        n = v
        
    return answer