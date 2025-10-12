from collections import deque

N = int(input())
adj = [[] for _ in range(N+1)]

for _ in range(N-1):
  a, b = map(int, input().split())
  adj[a].append(b)
  adj[b].append(a)
  
p = [0] * (N+1)
visited = [False] * (N+1)

visited[1] = True
q = deque([(1, 0)])

while q:
  node, level = q.popleft()
  
  for n in adj[node]:
    if not visited[n]:
      p[n] = node
      q.append((n, level+1))
      visited[n] = True

for i in range(2, N+1):
  print(p[i])