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
const array = [];

for (let i = 1; i <= N; i++) {
  array.push(input[i]);
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (array[i].length < array[j].length) {
      [array[i], array[j]] = [array[j], array[i]];
    }

    else if (array[i].length === array[j].length) {
      if (sumSerial(array[i]) < sumSerial(array[j])) {
        [array[i], array[j]] = [array[j], array[i]];
      }

      else if (sumSerial(array[i]) === sumSerial(array[j])) {
        if (array[i] < array[j]) {
          [array[i], array[j]] = [array[j], array[i]];
        }
      }
    }
  }
}

console.log(array.join('\n'))