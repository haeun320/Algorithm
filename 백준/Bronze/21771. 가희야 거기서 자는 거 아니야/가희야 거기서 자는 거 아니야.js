const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const [R, C] = input[0].split(' ').map(Number);
const [Rg, Cg, Rp, Cp] = input[1].split(' ').map(Number);
const array = [];

for (let i = 2; i < 2+R; i++) {
  array.push(input[i].split(''));
}

function isFilledSquare(i, j) {
  // 배게가 가려지는 부분 없이 있는가
  for (let p = i; p < i+Rp; p++) {
    for (let q = j; q < j+Cp; q++) {
      if (array[p][q] !== 'P')
        return false;
    }
  }
  return true;
}

function solution() {
  for (let i = 0; i < R; i++) {
    const index = array[i].indexOf('P');
    if (index !== -1) {
      if (!isFilledSquare(i, index)){
        return 1;
      }
      return 0;
    }
  }

  return 0;
}

console.log(solution())
