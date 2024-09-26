const fs = require('fs');
const { maxHeaderSize } = require('http');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync(0).toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class MaxHeap {
  constructor() {
    this.H = [0];
  }
  size() {
    return this.H.length - 1;
  }
  swap(a, b) {
    return [this.H[a], this.H[b]] = [this.H[b], this.H[a]];
  }
  upHeap(i) {
    if (i === 1)
      return;
    const parent = Math.floor(i/2);
    if (this.H[i] > this.H[parent]) {
      this.swap(i, parent);
      this.upHeap(parent);
    }
  }
  downHeap(i) {
    if (i * 2 > this.size())
      return;
    let larger = i * 2;
    if (i*2+1 <= this.size() && this.H[2*i+1] > this.H[larger])
      larger = 2*i+1;
    if (this.H[i] >= this.H[larger])
      return;
    this.swap(i, larger);
    this.downHeap(larger);
  }
  push(item) {
    this.H.push(item);
    this.upHeap(this.size());
  }
  removeMax() {
    if (this.size() === 0) 
      return 0;
    
    const key = this.H[1];
    this.H[1] = this.H[this.size()];
    this.H.pop();
    this.downHeap(1);
    return key;
  }

  takeGift(wish) {
    const box = this.H[1];
    if (wish > box)
      return 0;
    
    this.H[1] -= wish;
    this.downHeap(1);
    return 1;
  }
}

function solution() {
  const [N, M] = input[0].split(' ').map(Number);
  const gift = input[1].split(' ').map(Number);
  const wish = input[2].split(' ').map(Number);
  const Q = new MaxHeap();

  for (const x of gift) {
    Q.push(x);
  }

  for (const w of wish) {
    if (!Q.takeGift(w))
      return 0;
  }
  return 1;
}

console.log(solution());