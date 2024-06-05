function solution(num_list) {
    var lastIndex = num_list.length - 1;
    
    var lastValue = num_list[lastIndex];
    var prevValue = num_list[lastIndex - 1]
    
    if (lastValue > prevValue){
        num_list.push(lastValue - prevValue);
    }
    else {
        num_list.push(lastValue * 2);
    }
    
    return num_list;
}