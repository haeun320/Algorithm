from collections import deque

def bfs(visited, y, x, w, h, graph):
  q = deque([(y,x)])
  visited[y][x] = False

  # 상하좌우대각선
  dy = [-1, -1, 0, 1, 1, 1, 0, -1]
  dx = [0, 1, 1, 1, 0, -1, -1, -1]

  while q:
    vy, vx = q.popleft()

    for i in range(8):
      ny = vy + dy[i]
      nx = vx + dx[i]

      if ny < 0 or ny >= h or nx < 0 or nx >= w:
        continue

      if not visited[ny][nx] and graph[ny][nx] == 1:
        q.append((ny, nx))
        visited[ny][nx] = True

  return 1

# ========== main ==========
while True:
  w, h = map(int, input().split())
  if w == h == 0:
    break

  visited = [[False for _ in range(w)] for _ in range(h)]
  graph = []

  for _ in range(h):
    graph.append(list(map(int, input().split())))

  # 섬 개수 세기
  cnt = 0
  for y in range(h):
    for x in range(w):
      if not visited[y][x] and graph[y][x] == 1:
        cnt += bfs(visited, y, x, w, h, graph)

  print(cnt)