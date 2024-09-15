const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class Node {
  constructor(data){
    this.prev = null;
    this.next = null;
    this.data = data;
  }
}

class Dequeue {
  constructor(){
    this.front = null;
    this.rear = null;
  }

  addRear(data){
    const node = new Node(data);

    if (!this.front){
      this.front = node;
      this.rear = node;
      return;
    }

    node.prev = this.rear;
    this.rear.next = node;
    this.rear = node;
  }

  addFront(data){
    const node = new Node(data);

    if (!this.front){
      this.front = node;
      this.rear = node;
      return;
    }

    node.next = this.front;
    this.front.prev = node;
    this.front = node;
  }

  getFront(){
    return this.front.data;
  }

  getString(){
    let string = "";
    let node = this.front;

    while (node){
      string += node.data;
      node = node.next;
    }
    
    return string;
  }
}

let readIndex = 0;
const T = Number(input[readIndex++]);

for (let i = 0; i < T; i++){
  const N = Number(input[readIndex++]);
  const inputCard = input[readIndex++].split(' ');

  const result = new Dequeue();
  result.addFront(inputCard[0]);

  for (let j = 1; j < N; j++){
    const card = inputCard[j];

    if (card <= result.getFront())
      result.addFront(card);
    else
    result.addRear(card);
  }

  console.log(result.getString());
}