function solution(a, b, c) {
    if (a != b && b != c && c != a){
        return addNumber(a, b, c, 1);
    }
    else if (a == b && b == c && c == a){
        return addNumber(a, b, c, 3);
    }
    else {
        return addNumber(a, b, c, 2);
    }
}

function addNumber(a, b, c, p) {
    var result = 1;
    for (i = 1; i <= p; i++){
        result *= a**i + b**i + c**i;
    }
    return result;
}