from itertools import permutations

def isPrime(n):
    if n == 1 or n == 0:
        return False
    e = int(n**(1/2))
    for i in range(2, e+1):
        if n % i == 0:
            return False
    return True
        

def solution(numbers):
    li = list(map(int, str(numbers)))
    
    result = set()
    for i in range(1, len(li)+1):
        comb = list(map(list, permutations(li, i)))
        
        for c in comb:
            n = int("".join(map(str, c)))
            if isPrime(n):
                result.add(n)
                
    return len(result)
            