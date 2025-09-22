import math

def solution(progresses, speeds):
    days = []
    n = len(progresses)
    for i in range(n-1, -1, -1):
        p = progresses[i]
        s = speeds[i]
        d = math.ceil((100 - p) / s)
        days.append(d)
    
    result = []
    while days:
        d = days.pop()
        cnt = 1
        while days and days[len(days)-1] <= d:
            days.pop()
            cnt += 1
        result.append(cnt)
        
    return result
            
        