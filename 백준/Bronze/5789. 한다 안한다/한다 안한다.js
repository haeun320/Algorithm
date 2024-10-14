const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = Number(input[0]);
let result = "";

for(let i = 0; i < N; i++) {
  let array = input[i+1].split('').map(Number);
  let doit = 0;

  for (let j = 0; j < Math.floor(array.length/2); j++) {
    if (array[j] === array[array.length - 1 - j])
      doit = 1;
    else
      doit = 0;
  }

  result += doit === 1 ? "Do-it\n" : "Do-it-Not\n";
}

console.log(result.trim());