function solution(numbers) {
    let arr = [];
    for (let i = 0; i < numbers.length; i++){
        for (let j = i+1; j < numbers.length; j++){
            arr.push(numbers[i] + numbers[j]);
        }
    }
    let set = new Set(arr);
    let answer = [...set].sort((a,b)=>a-b);
    return answer;
}