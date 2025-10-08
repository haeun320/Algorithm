from collections import deque

N, K = map(int, input().split())
visited = [False] * 100001

def bfs():
  visited[N] = True
  q = deque([(N, 0)])
  
  while q:
    pos, time = q.popleft()
    if pos == K:
      return time
    
    if pos*2 <= 100000 and not visited[pos*2]:
      q.append((pos*2, time))
      visited[pos*2] = True
    
    if pos-1 >= 0 and not visited[pos-1]:
      q.append((pos-1, time+1))
      visited[pos-1] = True
      
    if pos+1 <= 100000 and not visited[pos+1]:
      q.append((pos+1, time+1))
      visited[pos+1] = True
      
  return -1

print(bfs())