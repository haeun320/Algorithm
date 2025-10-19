n = int(input())
m = int(input())
f = [[] for _ in range(n+1)]

for i in range(m):
  a, b = map(int, input().split())
  f[a].append(b)
  f[b].append(a)

visited = [False] * (n+1)
visited[1] = True
cnt = 0

for p in f[1]:
  if not visited[p]:
    visited[p] = True
    cnt += 1
  # print(f"p = {p}, f[p] = {f[p]}")
  for q in f[p]:
    if not visited[q]:
      # print("insert", q)
      cnt += 1
      visited[q] = True
      
print(cnt)