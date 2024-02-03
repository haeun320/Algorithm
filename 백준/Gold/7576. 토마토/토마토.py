import sys
from collections import deque
input = sys.stdin.readline

def bfs(tomato, q):
  while q:
    x, y = q.popleft()
  
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or nx >= N or ny < 0 or ny >= M:
        continue
      
      if tomato[nx][ny] == 0:
        tomato[nx][ny] = tomato[x][y] + 1
        q.append((nx, ny))

M, N = map(int, input().split()) #가로, 세로

tomato = [list(map(int, input().split())) for _ in range(N)]

q = deque()
for i in range(N):
  for j in range(M):
    if tomato[i][j] == 1:
      q.append((i, j))
      
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

bfs(tomato, q)

max = 0
for i in tomato:
  for j in i:
    if j > max:
      max = j
    elif j == 0:
      print(-1)
      exit()
      
print(max-1)
