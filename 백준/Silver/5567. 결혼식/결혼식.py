from collections import deque

def bfs():
  q = deque([(1, 0)])
  visited[1] = True
  cnt = 0
  
  while q:
    n, l = q.popleft()
    cnt += 1
    
    if l > 1:
      continue
    
    for p in f[n]:
      if not visited[p]:
        visited[p] = True
        q.append((p, l+1))
  
  return cnt-1 # 자기자신 제외

n = int(input())
m = int(input())
f = [[] for _ in range(n+1)]

for i in range(m):
  a, b = map(int, input().split())
  f[a].append(b)
  f[b].append(a)
  
# print(f)

visited = [False] * (n+1)
cnt = bfs()
print(cnt)