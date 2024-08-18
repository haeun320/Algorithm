function solution(N, stages) {
    let challenger = new Array(N+2).fill(0);
    for (const stage of stages){
        challenger[stage]++;
    }
    
    const stageArray = [];
    let total = stages.length;
    
    for (let i = 1; i <= N; i++){
        stageArray.push({
            "stage": i,
            "failRate": challenger[i] / total,
        })
        total -= challenger[i];
    }
    
    stageArray.sort((a, b) => b.failRate - a.failRate);
    return stageArray.map(item => item.stage);
}