function solution(num_list) {
    var mul = num_list.reduce((a,b) => a*b, 1);
    var sum = num_list.reduce((a,b) => a+b, 0);
    return Number(mul < sum**2);
}