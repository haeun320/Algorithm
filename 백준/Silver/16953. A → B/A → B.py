import sys
from collections import deque

A, B = map(int, sys.stdin.readline().split())
li = [B]
N = B

while (N > A):
    if (str(N)[-1] == "1"):
        N = int(str(N)[:-1])
        li.append(N)
    elif (N%2 == 0):
        N = N // 2
        li.append(N)
    else:
        print(-1)
        exit()

print(-1 if li[-1] < A else len(li))