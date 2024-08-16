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
    
    let obj = [
        {name: 1, cnt: cntStudent1},
        {name: 2, cnt: cntStudent2},
        {name: 3, cnt: cntStudent3},
    ];
    
    const maxCnt = Math.max(...obj.map(item => item.cnt));
    
    const maxNames = obj
        .filter(item => item.cnt === maxCnt)
        .map(item => item.name);
    
    return maxNames.sort((a, b) => a - b);
    
}