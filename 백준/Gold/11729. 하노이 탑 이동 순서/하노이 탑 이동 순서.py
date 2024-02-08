import sys
input = sys.stdin.readline

def move(n, start, target, aux):
  if n == 1:
    print(start, target)
    return
  move(n-1, start, aux, target)
  print(start, target)
  move(n-1, aux, target, start)
  
N = int(input().rstrip())

print(2**N-1)
move(N, 1, 3, 2)