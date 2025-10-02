N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))
ans = []
memo = set()

def back(n):
  if len(ans) == M:
    string = " ".join(map(str, ans))
    if string not in memo:
      print(string)
      memo.add(string)
    return
  
  for i in range(n, len(arr)):
    ans.append(arr[i])
    back(i)
    ans.pop()

back(0)