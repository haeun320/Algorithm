function solution(arr, queries) {
    for (var i = 0; i < queries.length; i++){
        var pos1 = queries[i][0];
        var pos2 = queries[i][1];
        
        var tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }
    return arr
}