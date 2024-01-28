import sys
from collections import deque
input = sys.stdin.readline
string = input().rstrip()
delString = input().rstrip()

delLen = len(delString)
stack = []

for i in string:
  stack.append(i)
  if len(stack) >= delLen:
    flag = 0
    for j in range(delLen):
      if stack[-(j+1)] != delString[-(j+1)]:
        flag = 1
        break
    if flag == 0:
      for j in range(delLen):
        stack.pop()
        
if stack:
  print("".join(stack))
else:
  print("FRULA")