function solution(code) {
    var ret = "";
    var mode = 0;
    for (var i = 0; i < code.length; i++){
        if (mode == 0){
            if (code[i] != '1' && i % 2 == 0)
                ret += code[i];
            else if (code[i] == '1')
                mode = 1;
        }
        else if (mode == 1){
            if (code[i] != '1' && i % 2 == 1){
                ret += code[i];
            }
            else if (code[i] == '1')
                mode = 0;
        }
    }
    return ret ? ret : "EMPTY";
}