const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const array = input[0].split('.');
let flag = 0;

for (let i = 0; i < array.length; i++){
  if (array[i] === '')
    continue;

  const len = array[i].length;
  if (len % 2 === 1){
    flag = -1;
    break;
  }

  let ANum = Math.floor(len/4);
  let BNum = Math.floor(len % 4 / 2);
  array[i] = 'AAAA'.repeat(ANum) + 'BB'.repeat(BNum);
}

flag === -1 ? console.log(flag) : console.log(array.join('.'));