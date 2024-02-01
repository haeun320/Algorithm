import sys
N = int(sys.stdin.readline().rstrip())

count = [0] * 100001 #계수 정렬
for _ in range(N):
  count[int(sys.stdin.readline().rstrip())] += 1
  
for i in range(1, 100001):
  for j in range(count[i]):
    sys.stdout.write(f"{i}\n")