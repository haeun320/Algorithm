const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class Heap {
  constructor() {
    this.H = [0];
  }

  size() {
    return this.H.length - 1;
  }

  swap(a, b) {
    [this.H[a], this.H[b]] = [this.H[b], this.H[a]];
  }

  upHeap(i) {
    if (i === 1)
      return;

    const parent = Math.floor(i/2);

    if (Math.abs(this.H[i]) < Math.abs(this.H[parent])){
      this.swap(i, parent);
      this.upHeap(parent);
    }

    else if (Math.abs(this.H[i]) === Math.abs(this.H[parent]) && this.H[i] < this.H[parent]){
      this.swap(i, parent);
      this.upHeap(parent);
    }
  }

  downHeap(i) {
    if (i*2 > this.size())
      return;

    let smaller = i*2;
    if (i*2+1 <= this.size()) {
      const left = this.H[i*2];
      const right = this.H[i*2+1];

      if (Math.abs(left) > Math.abs(right))
        smaller = i*2+1;
      else if (Math.abs(left) === Math.abs(right) && left > right)
        smaller = i*2+1;  
    }

    if (Math.abs(this.H[i]) > Math.abs(this.H[smaller])){
      this.swap(i, smaller);
      this.downHeap(smaller);
    }
    else if (Math.abs(this.H[i]) === Math.abs(this.H[smaller]) && this.H[i] > this.H[smaller]){
      this.swap(i, smaller);
      this.downHeap(smaller);
    }
  }

  push(x) {
    this.H.push(x);
    this.upHeap(this.size());
  }

  removeMin() {
    if (this.size() === 0)
      return 0;

    const key = this.H[1];
    this.H[1] = this.H[this.size()];
    this.H.pop();
    this.downHeap(1);

    return key;
  }
}

function solution(){
  let result = "";
  const N = Number(input[0]);
  const H = new Heap();

  for (let i = 1; i <= N; i++) {
    const x = Number(input[i]);
    if (x === 0) 
      result += H.removeMin() + "\n";
    else 
      H.push(x);
  }

  return result;
}

console.log(solution().trim());