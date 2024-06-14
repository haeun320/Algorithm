function solution(arr, queries) {
    queries.forEach(function([a,b]){
        console.log(a,b);
        [arr[a], arr[b]] = [arr[b], arr[a]];
    });
    return arr;
}