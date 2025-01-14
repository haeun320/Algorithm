def solution(array, commands):
    answer = []
    
    for i in range(len(commands)):
        command = commands[i]
        subArray = sorted(array[command[0]-1:command[1]])
        answer.append(subArray[command[2]-1])
        
    return answer