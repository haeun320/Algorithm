import sys
input = sys.stdin.readline

N = int(input().rstrip())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

C = [A[i]*B[i] for i in range(N)]
print(sum(C))