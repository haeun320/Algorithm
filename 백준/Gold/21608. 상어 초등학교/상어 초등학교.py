N = int(input())
like = [[] for _ in range(N**2+1)]
order = []
for _ in range(N**2):
  i, a, b, c, d = map(int, input().split())
  order.append(i)
  like[i] = set([a, b, c, d])

graph = [[0 for _ in range(N)] for _ in range(N)]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def findPosition(s):
  '''s: 자리 찾으려는 학생 번호
  return: 위치 좌표 (row, col)'''
  memo = []

  for row in range(N):
    for col in range(N):
      if graph[row][col] != 0:
        continue

      empty = 0
      fav = 0
      # (row, col) 상하좌우 탐색
      for i in range(4):
        ny = row + dy[i]
        nx = col + dx[i]

        if ny < 0 or ny >= N or nx < 0 or nx >= N:
          continue

        if graph[ny][nx] == 0:
          empty += 1
        elif graph[ny][nx] in like[s]:
          fav += 1

      memo.append((-fav, -empty, row, col))

  memo.sort()
  # print(f"{memo = }")
  return (memo[0][2], memo[0][3])


## main
# 자리 배치
for i in order:
  # print(f"{i = }")
  # print(f"{like[i] = }")
  row, col = findPosition(i)
  graph[row][col] = i
  # print(f"{row = }, {col = }")

# 만족도 구하기
result = 0
for row in range(N):
  for col in range(N):
    fav = 0
    # 상하좌우 탐색
    for i in range(4):
        ny = row + dy[i]
        nx = col + dx[i]

        if ny < 0 or ny >= N or nx < 0 or nx >= N:
          continue

        if graph[ny][nx] in like[graph[row][col]]:
          fav += 1
          
    result += 1 * (10 ** (fav-1)) if fav != 0 else 0
print(result)