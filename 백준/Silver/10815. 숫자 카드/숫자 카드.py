import sys
input = sys.stdin.readline

N = int(input().rstrip())
have = set(map(int, input().split()))
M = int(input().rstrip())
guess = list(map(int, input().split()))

for i in guess:
  if i in have:
    print(1, end = " ")
  else:
    print(0, end = " ")