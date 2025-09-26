from itertools import combinations

def solution(n, q, ans):
    # 1~5까지 모든 조합
    allCombos = list(combinations(range(1, n+1), 5))
    
    cnt = 0
    
    for combo in allCombos:
        combo = set(combo)
        
        isValid = True
        # 현재 조합이랑 질의문 전체 확인 -> 현재 조합이 가능한 조합인지 확인하기
        for i in range(len(q)):
            query = set(q[i])
            
            # 질의와 현재 조합의 교집합 길이가 시스템응답과 일치하지 않는 경우
            if ans[i] != len(combo & query):
                isValid = False
                break
        
        # 가능한 조합
        if isValid:
            cnt +=1
        
    return cnt
            
            