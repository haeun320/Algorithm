const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const array = input[0].split(' ').map(Number);
const sortedArray = [...array].sort((a,b) => a-b);

if (array.join(' ') === sortedArray.join(' ')) {
  console.log("Good");
}
else {
  console.log("Bad");
}