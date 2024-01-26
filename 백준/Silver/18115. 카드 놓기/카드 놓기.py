import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
skill = list(map(int, sys.stdin.readline().rstrip().split()))

li = deque()
li.extend(range(1, N+1))
card = deque()

for i in skill[::-1]:
    if i == 1:
        card.appendleft(li.popleft())
        
    elif i == 2:
        left = card.popleft()
        card.appendleft(li.popleft())
        card.appendleft(left)
    
    elif i == 3:
        card.append(li.popleft())
print(*card)