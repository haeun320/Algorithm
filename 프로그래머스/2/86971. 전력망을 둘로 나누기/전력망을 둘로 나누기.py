from collections import deque

def makeAdj(idx, wires, n):
    '''파라미터: 끊을 전선 인덱스, 전선 배열, n / 리턴: 채워진 인접리스트'''
    adj = [[] for _ in range(n+1)] # 인접리스트
    
    for i in range(n-1):
        if i == idx:
            continue # 끊을 전선 제외
        a, b = wires[i]
        adj[a].append(b)
        adj[b].append(a)
        
    return adj


def bfs(adj, n):
    '''1 송전탑과 이어진 송전탑 개수 반환'''
    visited = [False] * (n+1)
    visited[1] = True
    q = deque([1])
    
    cnt = 0
    
    while q:
        n = q.popleft()
        cnt += 1
        
        for top in adj[n]:
            if not visited[top]:
                q.append(top)
                visited[top] = True
                
    return cnt
    

def solution(n, wires):
    minAbs = 1e9
    
    for i in range(n-1):
        adj = makeAdj(i, wires, n)
        visited = [False] * (n+1) # 1-based
        
        cnt = bfs(adj, n)
        ab = abs(2*cnt - n)
        minAbs = min(minAbs, ab)
    
    return minAbs