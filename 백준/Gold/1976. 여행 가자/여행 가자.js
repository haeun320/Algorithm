const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

function find(parents, x) {
  if (parents[x] === x) {
    return x;
  }

  parents[x] = find(parents, parents[x]);
  return parents[x];
}

function union(parents, x, y) {
  const root1 = find(parents, x);
  const root2 = find(parents, y);

  parents[root2] = root1;
}

function isSameSet(parents, x, y) {
  const root1 = find(parents, x);
  const root2 = find(parents, y);

  return root1 === root2;
}

function solution() {
  const N = Number(input[0]);
  const M = Number(input[1]);
  const parents = Array.from({length: N+1}, (_,i)=>i);

  for (let i = 2; i < N+2; i++) {
    const op = input[i].split(' ').map(Number);
    
    for (let j = 0; j < N; j++) {
      if (op[j] === 1) {
        union(parents, i-1, j+1);
      }
    }
  }

  const plan = input[N+2].split(' ').map(Number);
  for (let i = 0; i < M-1; i++) {
    if (!isSameSet(parents, plan[i], plan[i+1]))
      return "NO";
  }
  return "YES";
}

console.log(solution());