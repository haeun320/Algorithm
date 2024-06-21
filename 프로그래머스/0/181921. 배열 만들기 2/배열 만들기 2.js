function solution(l, r) {
    answer = [-1];
    for (var i = l; i <= r; i++){
        numbers = [...i.toString()];
        var flag = 1;
        
        numbers.forEach(num => {
            if (num != '5' && num != '0')
                flag = 0;
        });
        
        if(flag == 1)
            answer.push(i);
    }
    
    if (answer.length > 1)
        answer.shift();
    
    return answer;
}