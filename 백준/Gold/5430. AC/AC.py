import sys
from collections import deque
T = int(sys.stdin.readline().rstrip())

for _ in range(T):
  p = list(sys.stdin.readline().rstrip())
  n = int(sys.stdin.readline().rstrip())
  inputs = sys.stdin.readline().rstrip().strip("[]")

  if inputs == "":
    x = deque()
  else:
    x = deque(inputs.split(","))
    
  flag = True
  cnt = 0
  for i in p:
    if i == "R":
      cnt += 1
    elif i == "D":
      if len(x) == 0:
        print("error")
        flag = False
        break
      
      if cnt % 2 == 0:
        x.popleft()
      else:
        x.pop()
  
  if flag:
    print("[" + ",".join(x) + "]" if cnt % 2 == 0 else "[" + ",".join(reversed(x)) + "]")
    #print(list(x) if cnt % 2 == 0 else list(reversed(x)))