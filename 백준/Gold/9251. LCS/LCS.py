A = input()
B = input()

lcs = [[0] * (len(A)+1) for _ in range(len(B)+1)]

for r in range(1, len(B)+1):
  for c in range(1, len(A)+1):
    if B[r-1] == A[c-1]:
      lcs[r][c] = lcs[r-1][c-1] + 1
    else:
      lcs[r][c] = max(lcs[r-1][c], lcs[r][c-1])
    
print(lcs[-1][-1])

# for r in lcs:
#   print(r)