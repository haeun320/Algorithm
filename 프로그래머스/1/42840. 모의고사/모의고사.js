function solution(answers) {
    let cntStudent1 = answers.map((num, index) => {
        if (index % 5 === num - 1) return 1;
        else return 0;
    }).reduce((a, b) => a + b, 0);
    
    let tmp2 = [2, 1, 2, 3, 2, 4, 2, 5];
    let cntStudent2 = answers.map((num, index) => {
        if (tmp2[index%8] == num) return 1;
        else return 0;
    }).reduce((a,b) => a + b, 0);
    
    let tmp3 = [3,3,1,1,2,2,4,4,5,5];
    let cntStudent3 = answers.map((num, index)=> {
        if (tmp3[index%10] == num) return 1;
        else return 0;
    }).reduce((a,b)=>a+b, 0);
    
    let scores = [cntStudent1, cntStudent2, cntStudent3];
    let maxScore = Math.max(...scores);
    
    let answer = [];
    if (cntStudent1 === maxScore) answer.push(1);
    if (cntStudent2 === maxScore) answer.push(2);
    if (cntStudent3 === maxScore) answer.push(3);
    
    return answer;
}