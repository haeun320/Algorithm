class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class Deque {
  constructor() {
    this.front = null;
    this.rear = null;
    this.size = 0;
  }

  addRear(data) {
    const node = new Node(data);

    if (!this.front) {
      this.front = node;
      this.rear = node;
    } else {
      node.prev = this.rear;
      this.rear.next = node;
      this.rear = node;
    }
    
    this.size++;
  }

  addFront(data) {
    const node = new Node(data);

    if (!this.front) {
      this.front = node;
      this.rear = node;
    } else {
      node.next = this.front;
      this.front.prev = node;
      this.front = node;
    }

    this.size++;
  }

  deleteFront() {
    if (!this.front) {
      return null;
    }

    const removeNode = this.front;
    this.front = this.front.next;

    if (!this.front) {
      this.rear = null;
    } else {
      this.front.prev = null;
    }

    this.size--;

    return removeNode.data;
  }

  deleteRear() {
    if (!this.rear) {
      return null;
    }

    const removeNode = this.rear;
    this.rear = this.rear.prev;

    if (!this.rear) {
      this.front = null;
    } else {
      this.rear.next = null;
    }

    this.size--;

    return removeNode.data;
  }

  isEmpty() {
    return this.size === 0;
  }
}