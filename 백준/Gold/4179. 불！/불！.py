from collections import deque

R, C = map(int, input().split())
graph = []
curFire = deque()

# 지훈 초기 위치
jy = 0 
jx = 0

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def isOutGraph(ny, nx):
  return ny < 0 or ny >= R or nx < 0 or nx >= C

def spreadFire():
  global graph, curFire
  for _ in range(len(curFire)):
    y, x = curFire.popleft()
    for i in range(4):
      ny = y + dy[i]
      nx = x + dx[i]

      if isOutGraph(ny, nx):
        continue
      
      if graph[ny][nx] == '#' or graph[ny][nx] == 'F':
        continue

      graph[ny][nx] = 'F'
      curFire.append((ny, nx))


def bfs():
  global graph

  if jy == 0 or jy == R-1 or jx == 0 or jx == C-1:
    return 1

  visited = [[False for _ in range(C)] for _ in range(R)]
  q = deque([(jy, jx, 0)]) # (y, x, level)
  visited[jy][jx] = True
  prevLevel = -1

  while q:
    vy, vx, vl = q.popleft() # 지훈이 현재 위치

    if prevLevel != vl:
      # 불 먼저 확산
      spreadFire()
      prevLevel = vl

    for i in range(4):
      ny = vy + dy[i]
      nx = vx + dx[i]

      if isOutGraph(ny, nx):
        continue

      if not visited[ny][nx] and graph[ny][nx] == '.':
        # 가장자리 도달 확인
        if ny == 0 or ny == R-1 or nx == 0 or nx == C-1:
          return vl + 2
        q.append((ny, nx, vl+1))
        visited[ny][nx] = True

  # 탈출 실패
  return -1


# ========= main ===========
for y in range(R):
  arr = list(input())
  graph.append(arr)
  for x in range(C):
    if arr[x] == 'J':
      jy = y
      jx = x
    elif arr[x] == 'F':
      curFire.append((y,x))

# bfs 실행
result = bfs()

if result == -1:
  print("IMPOSSIBLE")
else:
  print(result)