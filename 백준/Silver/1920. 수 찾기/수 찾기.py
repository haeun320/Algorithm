import sys
input = sys.stdin.readline

def binary_search(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    
    if array[mid] == target:
      return 1
    
    elif array[mid] > target:
      end = mid - 1
      
    else:
      start = mid + 1
    
  return 0

N = int(input().rstrip())
A = list(map(int, input().split()))
A.sort()
M = int(input().rstrip())
X = list(map(int, input().split()))

for i in X:
  print(binary_search(A, i, 0, N-1))