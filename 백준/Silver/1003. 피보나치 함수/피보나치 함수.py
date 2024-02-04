import sys
input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
  N = int(input().rstrip())
  
  d = []
  d.append([1,0])
  d.append([0,1])
  
  for i in range(2, N+1):
    d.append([d[i-1][j] + d[i-2][j] for j in range(2)])
    
  print(" ".join(map(str, d[N])))