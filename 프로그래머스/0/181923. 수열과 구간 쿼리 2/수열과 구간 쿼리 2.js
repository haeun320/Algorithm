function solution(arr, queries) {
    var answer = [];
    queries.forEach(function([s, e, k]){
        var min = -1;
        for (var i = s; i <= e; i++){
            if (arr[i] <= k)
                continue;
            min = (min == -1 ? arr[i] : Math.min(min, arr[i]));
        }
        answer.push(min);
    });
    return answer;
}