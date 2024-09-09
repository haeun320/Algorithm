const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class Node{
  constructor(data){
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class Dequeue{
  constructor(){
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  addFront(data){
    const node = new Node(data);

    if (!this.front){
      this.front = node;
      this.rear = node;
    }
    else{
      node.next = this.front;
      this.front.prev = node;
      this.front = node;
    }
    this.size++;
  }

  addRear(data){
    const node = new Node(data);

    if (!this.front){
      this.front = node;
      this.rear = node;
    }
    else{
      node.prev = this.rear;
      this.rear.next = node;
      this.rear = node;
    }
    this.size++;
  }

  deleteFront(){
    if (!this.front){
      return null;
    }
    
    const removeNode = this.front;
    this.front = this.front.next;

    if (!this.front){
      this.rear = null;
    }
    else {
      this.front.prev = null;
    }
    this.size--;
    return removeNode.data;
  }

  deleteRear(){
    if (!this.front){
      return null;
    }

    const removeNode = this.rear;
    this.rear = this.rear.prev;

    if (!this.rear){
      this.front = null;
    }
    else {
      this.rear.next = null;
    }
    this.size--;
    return removeNode.data;
  }

  peek(){
    return this.front.data;
  }

  getPosition(data){
    let p = this.front;
    let position = 0;

    while(p){
      if (p.data === data) return position;
      position++;
      p = p.next;
    }
    return -1;
  }
}

const [N, M] = input[0].split(' ').map(item => Number(item));

const deque = new Dequeue();
for (let i = 1; i <= N; i++){
  deque.addRear(i);
}

const num = input[1].split(' ').map(item => Number(item));

let count = 0;

for (let i = 0; i < M; i++){
  while (num[i] != deque.peek()){
    const position = deque.getPosition(num[i]);
    const isForward = position <= deque.size / 2;

    if (isForward){
      deque.addRear(deque.deleteFront());
    }
    else{
      deque.addFront(deque.deleteRear());
    }
    count++;
  }

  deque.deleteFront();
}

console.log(count);