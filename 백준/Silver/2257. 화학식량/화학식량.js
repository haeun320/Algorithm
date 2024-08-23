const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim();
// const input = fs.readFileSync('test.txt').toString().trim();

// 정리
// console.log(input);
const formula = [...input];

const weight = {"H": 1, "C": 12, "O": 16};

function isAtom(current){
  if (current === "H" || current === "C" || current === "O"){
    return true;
  }
  return false;
}

const len = formula.length;
let index = 0;
let stack = [];
let calculate = [];

function bracketProcess(){
  let tmp = [];

  while (stack[stack.length-1] != "(") {
    let current = stack[stack.length-1];
    
    if (current === "*") {
      stack.pop();
      tmp.push(stack.pop() * tmp.pop());
    }
    else{
      tmp.push(stack.pop());
    }
  }

  stack.pop();
  const tmpSum = tmp.reduce((a,b) => a+b, 0);
  stack.length > 0 ? stack.push(tmpSum) : calculate.push(tmpSum);
}

// 풀이
function solution(formula) {
  while(index < len){
    let current = formula[index];

    if (current === "("){
      stack.push(current);
    }
    else if (current === ")"){
      bracketProcess();
    }
    else if (stack.length > 0){ // 괄호 내부 처리
      if (isAtom(current)) stack.push(weight[current]);
      else {
        stack.push("*");
        stack.push(Number(current));
      }
    }
    else {
      if (isAtom(current)) calculate.push(weight[current]);
      else {
        calculate.push(Number(current) * calculate.pop());
      }
    }
    index++;
  }

  let result = calculate.reduce((a,b) => a+b, 0);
  console.log(result);
}

solution(formula);