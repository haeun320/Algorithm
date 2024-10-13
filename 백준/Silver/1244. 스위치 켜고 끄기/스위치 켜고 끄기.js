const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const switchNum = Number(input[0]);
const switches = input[1].split(' ').map(Number);
const studentNum = Number(input[2]);

for (let i = 0; i < studentNum; i++) {
  const [gender, num] = input[3 + i].split(' ').map(Number);

  if (gender === 1) {
    let index = num - 1;
    while (index < switchNum) {
      switches[index] = switches[index] === 0 ? 1 : 0;
      index += num;
    }
  }
  else if (gender === 2) {
    let index = num - 1;
    let left = index - 1;
    let right = index + 1;

    switches[index] = switches[index] === 0 ? 1 : 0;
    while (left >= 0 && right < switchNum) {
      if (switches[left] === switches[right]) {
        switches[left] = switches[left] === 0 ? 1 : 0;
        switches[right] = switches[right] === 0 ? 1 : 0;
        left--;
        right++;
      } else break;
    }
  }
}

for (let i = 0; i < switchNum; i += 20) {
  console.log(switches.slice(i, i + 20).join(' '));
}