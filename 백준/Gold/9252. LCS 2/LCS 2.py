A = input()
B = input()

lcs = [[0] * (len(A)+1) for _ in range(len(B)+1)]

for r in range(1, len(B)+1):
  for c in range(1, len(A)+1):
    if A[c-1] == B[r-1]:
      lcs[r][c] = lcs[r-1][c-1] + 1
    else:
      lcs[r][c] = max(lcs[r-1][c], lcs[r][c-1])
      
result = []
r = len(B)
c = len(A)

while lcs[r][c] > 0:
  if lcs[r-1][c] == lcs[r][c]: # 상
    r -= 1
    continue
  if lcs[r][c-1] == lcs[r][c]: # 좌
    c -= 1
    continue
  
  result.append(A[c-1])
  r -= 1
  c -= 1
  
print(lcs[-1][-1])
result.reverse()
print(''.join(result))