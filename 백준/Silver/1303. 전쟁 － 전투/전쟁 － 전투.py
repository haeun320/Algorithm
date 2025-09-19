from collections import deque

N, M = map(int, input().split())

graph = []
for _ in range(M):
  graph.append(list(input()))
  
visited = [[False for _ in range(N)] for _  in range(M)]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
  
def bfs(visited, x, y, c):
  q = deque([(x, y)])
  visited[y][x] = True
  cnt = 0
  
  while q:
    vx, vy = q.popleft()
    cnt += 1
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      
      if ny < 0 or ny >= M or nx < 0 or nx >= N:
        continue
      
      if not visited[ny][nx] and graph[ny][nx] == c:
        q.append((nx, ny))
        visited[ny][nx] = True
        
  return cnt

result = {'W': 0, 'B': 0}

for y in range(M):
  for x in range(N):
    if not visited[y][x]:
      c = graph[y][x]
      result[c] += bfs(visited, x, y, c) ** 2
      
print(result['W'], result['B'])