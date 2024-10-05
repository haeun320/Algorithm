const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

function sumSerial(serial) {
  let sum = 0;

  for(let value of serial) {
    if (value >= '0' && value <= '9') {
      sum += Number(value);
    }
  }

  return sum;
}

const N = Number(input[0]);
const array = input.slice(1);

array.sort((a, b) => {
  if (a.length !== b.length) return a.length - b.length;
  
  const sumA = sumSerial(a);
  const sumB = sumSerial(b);
  if (sumA !== sumB) return sumA - sumB;
  
  return a.localeCompare(b);
});


console.log(array.join('\n'))