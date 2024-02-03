import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
miro = [list(map(int, input().rstrip())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
  q = deque()
  q.append((x, y))
  
  while q:
    x, y = q.popleft()
    
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      
      if nx < 0 or nx >= N or ny < 0 or ny >= M:
        continue
      
      if miro[nx][ny] == 0:
        continue
      
      if miro[nx][ny] == 1:
        miro[nx][ny] = miro[x][y] + 1
        q.append((nx, ny))
        
  return miro[N-1][M-1]

print(bfs(0,0))