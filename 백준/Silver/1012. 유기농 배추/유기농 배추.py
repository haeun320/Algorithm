import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)
def dfs(x, y): 
  if x <= -1 or x >= N or y <= -1 or y >= M:
    return False
  
  if graph[x][y] == 1:
    graph[x][y] = 0
    dfs(x-1, y)
    dfs(x, y-1)
    dfs(x+1, y)
    dfs(x, y+1)
    return True
  
  return False

T = int(input().rstrip())

for _ in range(T):
  M, N, K = map(int, input().split()) #가로, 세로, 개수
  graph = [[0 for _ in range(M)]for _ in range(N)]
  
  for _ in range(K):
    X, Y = map(int, input().split())
    graph[Y][X] = 1
    
  cnt = 0
  for i in range(N):
    for j in range(M):
      if dfs(i, j) == True:
        cnt += 1
        
  print(cnt)