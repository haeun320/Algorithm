from collections import deque

def bfs(graph, V, visited):
    cnt = 0
    visited[V] = True
    q = deque()
    q.append(V)
    
    while q:
        v = q.popleft()
        cnt += 1
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
    
    print(cnt-1)


N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()
    
visited = [False] * (N+1)
bfs(graph, 1, visited)