import sys
input = sys.stdin.readline

N = int(input().rstrip())
li = [list(map(int, input().split())) for _ in range(N)]
li.sort()
for i in li:
  print(*i)