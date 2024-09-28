// MinHeap
// 배열 이용, 연산 편의상 0번 인덱스는 사용하지 않음

class MinHeap {
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
    if (this.H[i] < this.H[parent]){
      this.swap(i, parent);
      this.upHeap(parent);
    }
  }

  downHeap(i) {
    if (i*2 > this.size())
      return;

    let smaller = i*2;
    if (i*2+1 <= this.size() && this.H[i*2] > this.H[i*2+1])
      smaller = i*2+1;

    if (this.H[i] > this.H[smaller]){
      this.swap(i, smaller);
      this.downHeap(smaller);
    }
  }

  push(x) {
    this.H.push(x);
    this.upHeap(this.size());
  }

  removeMin(){
    const key = this.H[1];
    this.H[1] = this.H[this.size()];
    this.H.pop();
    this.downHeap(1);

    return key;
  }
}