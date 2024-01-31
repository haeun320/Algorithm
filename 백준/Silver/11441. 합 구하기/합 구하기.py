import sys
N = int(sys.stdin.readline().rstrip())
a = list(map(int, sys.stdin.readline().split()))

s = [0]
for i in range(N):
  s.append(s[i] + a[i])

M = int(sys.stdin.readline().rstrip())
for i in range(M):
  i, j = map(int, sys.stdin.readline().split())
  print(s[j]-s[i-1])