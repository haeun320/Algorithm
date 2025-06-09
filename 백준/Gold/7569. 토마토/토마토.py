from collections import deque

M, N, H = map(int, input().split())

graph = [[] for _ in range(H)]
q = deque() # (x, y, z, level)
remains = M * N * H

for i in range(H):
  for j in range(N):
    arr = list(map(int, input().split()))
    visited = [False] * M
    graph[i].append(list(zip(arr, visited)))

    for k in range(M):
      if arr[k] == 1:
        q.append((k, j, i, 0))
        graph[i][j][k] = (1, True)
        remains -= 1

      elif arr[k] == -1:
        graph[i][j][k] = (-1, True)
        remains -= 1
#
# print("======================")
# for i in range(H):
#   for j in range(N):
#     print(graph[i][j])
# print("======================")


dy = [0, 0, 0, 0, -1, 1]
dx = [0, 0, -1, 1, 0, 0]
dz = [-1, 1, 0, 0, 0, 0]

result = 0

while q:
  nx, ny, nz, nl = q.popleft()

  for i in range(6):
    x = nx + dx[i]
    y = ny + dy[i]
    z = nz + dz[i]

    if x < 0 or y < 0 or z < 0 or x>= M or y >= N or z >= H:
      continue

    value, visited = graph[z][y][x]

    if not visited and value == 0:
      q.append((x, y, z, nl + 1))
      result = nl + 1
      graph[z][y][x] = (1, True)
      remains -= 1

# print("======================")
# for i in range(H):
#   for j in range(N):
#     print(graph[i][j])
# print("======================")

if remains > 0:
  print(-1)

else:
  print(result)