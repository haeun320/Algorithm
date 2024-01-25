import sys
input = sys.stdin.readline

N, M = map(int, input().split())

A = list(map(int, input().split()))

S = [0]
R = [0]*M
for i in range(1, N+1):
  remains = (S[i-1] + A[i-1])%M
  S.append(remains)
  R[remains] += 1
cnt = S.count(0) - 1

for i in R:
  cnt += i * (i-1) // 2

print(cnt)