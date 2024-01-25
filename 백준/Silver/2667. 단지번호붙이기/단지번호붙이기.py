import sys
input = sys.stdin.readline

N = int(input().rstrip())
graph = []
num = 0

for _ in range(N):
  graph.append(list(map(int,input().rstrip())))

def dfs(x, y):
  global num
  if x < 0 or x >= N or y < 0 or y >= N:
    return False
  if graph[x][y] == 1:
    num += 1
    graph[x][y] = 0
    dfs(x-1 , y)
    dfs(x, y-1)
    dfs(x+1, y)
    dfs(x, y+1)
    return True
  return False

cnt = 0
num_list = []
for i in range(N):
  for j in range(N):
    num = 0
    if dfs(i, j) == True:
      cnt += 1
      num_list.append(num)
      
print(cnt)
for i in sorted(num_list):
  print(i)