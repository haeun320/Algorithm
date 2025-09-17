# import sys
# sys.stdin = open("input.txt", "r")
from collections import deque

def bfs(n):
    q = deque([n])
    visited[n] = True

    while q:
        v = q.popleft()
        for node in ad[v]:
            if not visited[node]:
                q.append(node)
                visited[node] = True

    return 1

N, M = map(int, input().split())
ad = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int, input().split())
    ad[u].append(v)
    ad[v].append(u)

for i in range(1, N+1):
    ad[i] = list(set(ad[i]))

visited = [False for _ in range(N+1)]
cnt = 0

for i in range(1, N+1):
    if not visited[i]:
        cnt += bfs(i)

print(cnt)