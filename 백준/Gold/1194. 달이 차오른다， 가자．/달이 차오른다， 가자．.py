from collections import deque

N, M = map(int, input().split())
graph = []
my = 0
mx = 0

def bfs():
  q = deque([(my, mx, 0, 0)]) # (y, x, level, 키)
  # visited[y][x][키조합]
  visited = [[[False for _ in range(64)] for _ in range (M)] for _ in range(N)]
  visited[my][mx][0] = 0

  dy = [-1, 1, 0, 0]
  dx = [0, 0, -1, 1]

  while q:
    vy, vx, vl, vk = q.popleft()

    for i in range(4):
      ny = vy + dy[i]
      nx = vx + dx[i]

      if ny < 0 or ny >= N or nx < 0 or nx >= M:
        continue
      
      if not visited[ny][nx][vk] and graph[ny][nx] != '#':

        curVal = graph[ny][nx]
        # print(f"현재 값 = {curVal}")
        # 출구 확인
        if curVal == '1':
          return vl + 1
        
        # 열쇠 획득
        if 'a' <= curVal <= 'f':
          # print(f"열쇠 획득")
          pos = ord(curVal) - 97
          nk = vk | (1 << pos)
          q.append((ny, nx, vl+1, nk))
          visited[ny][nx][nk] = True
          continue

        # print(f"현재 열쇠 {vk}")

        # 문 확인
        if 'A' <= curVal <= 'F':
          pos = ord(curVal) - 65
          if vk & (1 << pos) == 0:
            continue # 이동할 수 없는 문

        # 이동
        q.append((ny, nx, vl+1, vk))
        visited[ny][nx][vk] = True

  # 탈출 못함
  return -1



# ========== main =================
for y in range(N):
  arr = list(input())
  graph.append(arr)
  for x in range(M):
    if arr[x] == '0':
      my = y
      mx = x

# bfs 탐색
print(bfs())