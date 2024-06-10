function solution(numLog) {
    var result = ""
    for (i = 0; i < numLog.length; i++){
        if (numLog[i+1] == numLog[i] + 1)
            result += "w";
        else if (numLog[i+1] == numLog[i] - 1)
            result += "s";
        else if (numLog[i+1] == numLog[i] + 10)
            result += "d";
        else if (numLog[i+1] == numLog[i] - 10)
            result += "a"
    }
    return result;
}