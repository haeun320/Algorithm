import math

def solution():
  N = int(input())
  materials = {}

  for i in range(N):
    material, num = input().split()
    if (material in materials):
      materials[material] += int(num)
    else:
      materials[material] = int(num)
    
  amounts = list(materials.values())
  
  for i in amounts:
    target = math.floor(i * 1.618)
    if target in amounts:
      if amounts.count(target) > 1 or (i != target):
        print('Delicious!')
        return
  
  print('Not Delicious...')
  return

solution()