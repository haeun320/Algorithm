M, N = map(int, input().split())

def prime():
    sieve = [True] * (N+1)
    sieve[1] = False
    
    m = int(N ** 0.5)

    for i in range(2, m+1):
        if sieve[i] == True:
            for j in range(i*i, N+1, i):
                sieve[j] = False
    
    return [i for i in range(M, N+1) if sieve[i] == True]

print('\n'.join(map(str, prime())))
