import sys
input = sys.stdin.readline

N = int(input().rstrip())
weight = [int(input().rstrip()) for _ in range(N)]

weight.sort()

max = 0
for i in range(N):
  tmp = (N-i) * weight[i]
  if tmp > max:
    max = tmp
    
print(max)