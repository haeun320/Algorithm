import sys
input = sys.stdin.readline

def binary_search(array, target, start, end):
  while (start <= end):
    mid = (start + end) // 2
    
    if array[mid] == target:
      return 1
    elif array[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  return 0

N = int(input().rstrip())
have = list(map(int, input().split()))
M = int(input().rstrip())
guess = list(map(int, input().split()))

have.sort()

for i in guess:
  print(binary_search(have, i, 0, N-1), end = " ")