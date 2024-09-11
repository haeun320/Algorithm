const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

function isPalindrome(word){
  const reverse = word.split('').reverse().join('');
  return word === reverse;
}

let readIndex = 0;
const T = Number(input[readIndex++]);

for(let i = 0; i < T; i++){
  const k = Number(input[readIndex++]);

  let words = [];
  for (let j = 0; j < k; j++)
    words.push(input[readIndex++]);

  let findPalindrome = false;
  
  for (let p = 0; p < k; p++){
    for (let q = 0; q < k; q++){
      if (p === q) continue;

      let word = words[p]+words[q];
      if(isPalindrome(word)){
        console.log(word);
        findPalindrome = true;
        break;
      }
    }
    if (findPalindrome) break;
  }

  if (!findPalindrome)
    console.log(0);
}