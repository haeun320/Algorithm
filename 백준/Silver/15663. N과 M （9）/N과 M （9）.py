N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))

ans = []
memo = set()
visited = [False] * N

def back(n):
  if len(ans) == M:
    string = " ".join(map(str, ans))
    if string not in memo:
      print(string)
      memo.add(string)
    return

  for i in range(N):
    if not visited[i]:
      ans.append(arr[i])
      visited[i] = True
      back(i+1)
      ans.pop()
      visited[i] = False

back(0)