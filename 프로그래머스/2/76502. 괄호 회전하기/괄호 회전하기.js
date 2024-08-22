function checkbracket(s){
    let array = [...s];
    let subStack = [];

    for (let i = 0; i < array.length; i++){
        let ch = array[i];
        let top = subStack[subStack.length-1];
        
        if (ch === "(" || ch === "{" || ch === "[")
            subStack.push(ch);
        else if (ch === ")" && top === "(")
            subStack.pop();
        else if (ch === "}" && top === "{")
            subStack.pop();
        else if (ch === "]" && top === "[")
            subStack.pop();
        else
            subStack.push(ch);
    }
    if (subStack.length > 0){
        return false;
    }
    return true;
}

function solution(s) {
    const len = s.length;
    let count = 0;
    
    for (let i = 0; i < len; i++){
        checkbracket(s) && count++;
        s = s.substr(1) + s[0];
    }
    
    return count;
}