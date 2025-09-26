import math

def makeKNum(n, k):
    knum = []
    while n > 0:
        knum.append(str(n % k))
        n = n // k
    return knum[::-1]

def isPrime(n):
    if n == 1:
        return False

    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False

    return True

def solution(n, k):
    knum = ''.join(makeKNum(n, k))
    li = knum.split('0')
    # 0 사이로 끊어서 소수 판별
    cnt = 0
    for l in li:
        if l != '' and isPrime(int(l)):
            cnt += 1
    return cnt
