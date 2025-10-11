from collections import deque

T = int(input())

for _ in range(T):
  N, M = map(int, input().split())
  arr = list(map(int, input().split()))
  q = deque([])
  for i in range(N):  
    q.append((arr[i], i))
  
  cnt = 0
  while q:
    n, i = q.popleft()
    if q and n < max(q)[0]:
      q.append((n, i))
      continue
    cnt += 1
    if i == M:
      break
  print(cnt)