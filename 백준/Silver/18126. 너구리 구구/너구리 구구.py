import sys
sys.setrecursionlimit(1000000)

n = int(input())
graph = [[] for _ in range(n + 1)]

for i in range(n-1):
  a, b, c = map(int, input().split())
  graph[a].append((b, c))
  graph[b].append((a, c))

def dfs(visited, v, w):
  visited[v] = True
  max_w = 0
  
  for i in graph[v]:
    nv, nw = i

    if not visited[nv]:
      dw = dfs(visited, nv, w + nw)
      max_w = max(max_w, dw)

  return max(w, max_w)

visited = [False] * (n + 1)
print(dfs(visited, 1, 0))