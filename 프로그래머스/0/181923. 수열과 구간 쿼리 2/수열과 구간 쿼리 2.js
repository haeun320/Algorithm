function solution(arr, queries) {
    var answer = [];
    queries.forEach(function([s, e, k]){
        var min = 1000000, flag = 0;
        
        for (var i = s; i <= e; i++){
            if (arr[i] > k && arr[i] < min){
                min = arr[i];
                flag = 1;
            }
        }
        answer.push(flag == 0 ? -1 : min);
    });
    return answer;
}