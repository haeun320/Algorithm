def solution(A,B):
    result = 0
    A.sort(reverse = True)
    B.sort()
    
    for i in range(len(A)):
        result += A.pop() * B.pop()
    
    return result
