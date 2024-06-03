function solution(a, d, included) {
    var sum = 0;
    for (i = 0; i < included.length; i++){
        if (included[i]){
            sum += a + i * d;
        }
    }
    return sum;
}