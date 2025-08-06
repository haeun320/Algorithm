N = int(input())
arr = list(map(int, input().split()))

def solve(N, arr):
  arr.sort()

  if arr[0] != 1:
    return 1
  
  prefix = 1

  for i in range(1, N):
    # print(f"prefix = {prefix}, arr[{i}] = {arr[i]}")
    if prefix + 1 >= arr[i]:
      prefix += arr[i]
    else:
      return prefix + 1
  
  return prefix + 1

print(solve(N, arr))
