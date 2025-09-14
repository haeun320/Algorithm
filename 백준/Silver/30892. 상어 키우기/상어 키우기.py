# import sys
# sys.stdin = open("input.txt", "r")

N, K, T = map(int, input().split())
size = list(map(int, input().split()))

size.sort()

eatable = []
shark_idx = 0

for _ in range(K):
    while shark_idx < N and size[shark_idx] < T:
        eatable.append(size[shark_idx])
        shark_idx += 1

    if not eatable:
        break

    T += eatable.pop()

print(T)