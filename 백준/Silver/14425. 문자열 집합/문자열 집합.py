import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S = set()
for _ in range(N):
  S.add(input().rstrip())
  
cnt = 0
for _ in range(M):
  string = input().rstrip()
  if string in S:
    cnt += 1
  
print(cnt)