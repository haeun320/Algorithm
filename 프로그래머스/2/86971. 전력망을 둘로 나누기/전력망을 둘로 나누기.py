uf = []

def find(a):
    global uf
    
    if uf[a] < 0:
        return a
    
    uf[a] = find(uf[a])
    return uf[a]


def union(a, b):
    global uf
    
    pa = find(a)
    pb = find(b)
    
    if pa == pb:
        return
    
    uf[pa] += uf[pb]
    uf[pb] = pa


def solution(n, wires):
    global uf
    
    minAbs = 1e9
    
    for i in range(n-1):
        # 전선 잇기
        uf = [-1] * (n+1) # 0 인덱스 무시
        
        for j in range(n-1):
            if i == j:
                continue # 끊을 전선 무시
            a, b = wires[j]
            union(a, b)
        
        size = [x for x in uf[1:] if x < 0]
        minAbs = min(minAbs, abs(size[0]-size[1]))
        
    return minAbs
            