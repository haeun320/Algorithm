def solution(s):
    w = s.split(' ')
    answer = ''
    for x in w:
        answer += (x[:1].upper() + x[1:].lower() + ' ')
    return answer[:-1]