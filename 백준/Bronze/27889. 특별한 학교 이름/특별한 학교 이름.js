const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const school = {
  NLCS: "North London Collegiate School",
  BHA: "Branksome Hall Asia",
  KIS: "Korea International School",
  SJA: "St. Johnsbury Academy"
}

console.log(school[input[0]])