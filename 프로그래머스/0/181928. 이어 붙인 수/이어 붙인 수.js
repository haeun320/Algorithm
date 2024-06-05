function solution(num_list) {
    var odd = 0, even = 0;
    num_list.forEach(function(num) {
        if (num % 2 == 0) {
            even *= 10;
            even += num;
        }
        else {
            odd *= 10;
            odd += num;
        }
    });
    
    return odd + even;
}