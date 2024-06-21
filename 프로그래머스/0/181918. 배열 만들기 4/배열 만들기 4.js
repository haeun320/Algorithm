function solution(arr) {
    var stk = [];
    
    for (var i = 0; i < arr.length;){
        if (stk.length == 0)
            stk.push(arr[i++]);
        else {
            if (stk[stk.length-1] < arr[i])
                stk.push(arr[i++]);
            else
                stk.pop(arr[i]);
        }
    }
    
    return stk;
}