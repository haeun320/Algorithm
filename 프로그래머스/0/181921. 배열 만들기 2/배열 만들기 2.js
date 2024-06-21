function solution(l, r) {
    answer = [-1];
    for (var i = l; i <= r; i++){
        numbers = [...i.toString()];
        var flag = numbers.every(num => num == '5' || num == '0');
    
        if(flag)
            answer.push(i);
    }
    
    return answer.length > 1 ? answer.slice(1) : answer;
}