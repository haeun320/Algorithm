N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))
visited = [False] * 10000
ans = []

def back():
  if len(ans) == M:
    print(" ".join(map(str, ans)))
    return
  
  for a in arr:
    if not visited[a]:
      ans.append(a)
      visited[a] = True
      back()
      ans.pop()
      visited[a] = False
      
back()