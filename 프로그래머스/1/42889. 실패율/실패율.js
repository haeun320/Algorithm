function solution(N, stages) {
    let stageArray = [];
    
    for (let i = 0; i < N ;i++){
        stageArray.push({
            "stage": i+1,
            "failRate": 0,
        })
    }
    
    for (let i = 0; i < N; i++){
        let reachNum = 0;
        let notClearNum = 0;
        
        for (let j = 0; j < stages.length; j++){
            if (stages[j] >= i+1){
                reachNum++;
                if (stages[j] === i+1) notClearNum++;
            }
        }
        stageArray[i].failRate = notClearNum / reachNum;
    }
    
    stageArray.sort((a, b) => b.failRate - a.failRate);    
    
    return stageArray.map(item => item.stage);
}