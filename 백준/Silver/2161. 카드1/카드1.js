const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class Node {
  constructor(data){
    this.data = data;
    this.next = null;
  }
}

class Queue {
  constructor(){
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  enqueue(data){
    const node = new Node(data);

    if (!this.front){
      this.front = node;
      this.rear = node;
    }
    else {
      this.rear.next = node;
      this.rear = node;
    }
    this.size++;
  }

  dequeue(){
    if (!this.front)
      return null;

    const delNode = this.front;
    this.front = delNode.next;

    if (!this.front)
      this.rear = null;

    this.size--;
    return delNode.data;
  }

  getSize(){
    return this.size;
  }
}

const N = Number(input[0]);
const queue = new Queue();

for (let i = 1; i <= N; i++){
  queue.enqueue(i);
}

let result = [];
while(queue.getSize() > 1){
  result.push(queue.dequeue());
  queue.enqueue(queue.dequeue());
}
result.push(queue.dequeue());

console.log(result.join(' '));