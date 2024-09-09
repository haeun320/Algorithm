// 배열 이용: push(), shift() 메서드 이용

// 연결리스트 이용
class Node {
  constructor(data){
    this.data = data;
    this.next = null;
  }
}

class Queue {
  constructor(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push(data){
    const newNode = new Node(data);

    if (!this.head) { // 큐가 비어있을 때
      this.head = newNode;
      this.tail = newNode;
    }
    else {
      this.tail.next = newNode;
      this.tail = newNode;
    }

    this.size++;
  }

  pop(){
    if (!this.head){
      return null;
    }

    const removeNode = this.head;
    this.head = this.head.next;

    if (!this.head){
      this.tail = null;
    }

    this.size--;

    return removeNode.data;
  }

  isEmpty(){
    return this.size === 0;
  }
}