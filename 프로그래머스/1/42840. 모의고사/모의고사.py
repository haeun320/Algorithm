def solution(answers):
    students = [0,0,0]
    
    answerLen = len(answers)
    
    for idx, answer in enumerate(answers):
        # student1  
        if (answer == idx % 5 + 1):
            students[0] += 1
            
        # student2
        student2patters = [2,1,2,3,2,4,2,5]
        if (answer == student2patters[idx%8]):
            students[1] += 1
        
        # student3
        student3patters = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
        if (answer == student3patters[idx%10]):
            students[2] += 1
        
    maxValue = max(students)
    
    return sorted([x for x in range(1,4) if (students[x-1] == maxValue)])
            
    
    
    