const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class Queue {
  items = [];
  front = 0;
  rear = 0;

  enqueue(item){
    this.items.push(item);
    this.rear++;
  }

  dequeue(){
    return this.items[this.front++];
  }

  size(){
    return this.rear - this.front;
  }
}

const [N, K] = input[0].split(' ').map(item => Number(item));
let queue = new Queue();

for (let i = 1; i <= N; i++){
  queue.enqueue(i);
}

let answer = [];

while(queue.size() > 1){
  for (let i = 0; i < K-1; i++){
    queue.enqueue(queue.dequeue());
  }
  answer.push(queue.dequeue());
}
answer.push(queue.dequeue());

console.log("<" + answer.join(', ') + ">");