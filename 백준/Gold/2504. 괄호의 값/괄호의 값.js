const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const brackets = input[0].split('');
const value = {
  "(": 2,
  "[": 3,
}

function solution(){
  const stack = [];
  const flagStack = [];
  let result = "";
  
  for (const bracket of brackets){
    const stackLen = stack.length;
    const flagStackLen = flagStack.length;

    if (bracket === "(" || bracket === "[") {
      if (stackLen === 0 ){
        result += "+" + value[bracket];
      }
      else if (flagStack[flagStackLen-1] === stackLen) {
        result += "+" + value[bracket];
      }
      else {
        flagStack.push(stackLen);
        result += "*(" + value[bracket];
      }
  
      stack.push(bracket);
    }
  
    else if (bracket === ")" || bracket === "]") {
      if (bracket === ")" && stack[stackLen-1] !== "(")
        return 0;
      else if (bracket === "]" && stack[stackLen-1] !== "[")
        return 0;

      if (flagStack[flagStackLen-1] === stackLen){
        flagStack.pop();
        stack.pop();
        result += ")";
      }
      else {
        stack.pop();
      }
    }
  
    else{
      return 0;
    }
  }

  if (stack.length !== 0)
    return 0;
  
  return result;
}

console.log(eval(solution()));