def solution(numbers):
    li = []
    for n in numbers:
        S = str(n)
        s = S * 4
        li.append((s[:4], len(S))) # (패딩 처리한 수, 실제 길이)

    li.sort(reverse=True)
    
    result = ""
    for n, idx in li:
        result += ''.join(n[:idx])
    
    result = result.lstrip('0')
    return result if result != "" else "0"
        