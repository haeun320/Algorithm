N = int(input())

words = []
for _ in range(N):
  words.append(input())

words = sorted(list(set(words)))
N = len(words)

child = [[] for _ in range(N)]

for i in range(N):
  for j in range(i+1, N):
    l = len(words[i])
    if words[i] != words[j][:l]:
      break
    child[i].append(j)

cnt = 0
for i in range(N):
  if len(child[i]) == 0:
    cnt += 1

print(cnt)