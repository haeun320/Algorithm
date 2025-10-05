from collections import deque

N = int(input())

memo = set()
tree = dict()
tree[N] = 0 # 루트노드
q = deque([N])

# 역추적 트리
while q:
  p = q.popleft()
  if p == 1:
    break
  
  next = [p-1]
  if p % 2 == 0:
    next.append(p//2)
  if p % 3 == 0:
    next.append(p//3)
  
  for i in next:
    if i in memo:
      continue
    memo.add(i)
    tree[i] = p
    
    q.append(i)
    
# 1부터 N(루트)까지 출력 -> 역순으로 뒤집기
ans = []
p = 1
while p > 0:
  ans.append(p)
  p = tree[p]
  
ans.reverse()

print(len(ans)-1)
print(' '.join(map(str, ans)))