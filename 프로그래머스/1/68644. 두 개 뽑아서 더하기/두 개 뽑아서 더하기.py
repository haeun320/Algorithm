def solution(numbers):
    arr = []
    
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            arr.append(numbers[i] + numbers[j])
            
    return sorted(set(arr))