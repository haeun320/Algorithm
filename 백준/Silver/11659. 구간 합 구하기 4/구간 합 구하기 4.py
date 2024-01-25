import sys
input = sys.stdin.readline
N, M = map(int, input().split())

A = list(map(int, input().split()))
S = [0] * (N+1)

for i in range(1, N+1):
  S[i] = S[i-1] + A[i -1]
  
for i in range(M):
  i, j = map(int, input().split())
  rst = S[j] - S[i-1]
  print(rst)