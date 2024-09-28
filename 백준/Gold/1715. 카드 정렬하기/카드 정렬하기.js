const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class MinHeap{
  constructor(){
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
    if (this.H[i] < this.H[parent]){
      this.swap(i, parent);
      this.upHeap(parent);
    }
  }

  downHeap(i) {
    if (i*2 > this.size())
      return;

    let smaller = i*2;
    if (i*2+1 <= this.size() && this.H[smaller] > this.H[i*2+1])
      smaller = i*2+1;

    if (this.H[i] > this.H[smaller]) {
      this.swap(i, smaller);
      this.downHeap(smaller);
    }
  }

  push(x) {
    this.H.push(x);
    this.upHeap(this.size());
  }

  deleteMin() {
    const key = this.H[1];
    this.H[1] = this.H[this.size()];
    this.H.pop();
    this.downHeap(1);
    return key;
  }
}

function solution() {
  const N = Number(input[0]);
  const card = new MinHeap();
  for (let i = 1; i <= N; i++) {
    card.push(Number(input[i]));
  }

  let result = 0;
  
  while (card.size() > 1) {
    const merge = card.deleteMin() + card.deleteMin();
    result += merge;
    card.push(merge);
  }

  return result;
}

console.log(solution());