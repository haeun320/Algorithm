const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

class TreeNode {
  constructor(key){
    this.left = null;
    this.right = null;
    this.key = key;
  }
}

class BinarySearchTree {
  constructor(){
    this.root = null;
  }

  insert(key) {
    this.root = this._insertRec(this.root, key);
  }

  _insertRec(node, key) {
    if (!node)
      return new TreeNode(key);

    if (key < node.key)
      node.left = this._insertRec(node.left, key);
    else if (key > node.key)
      node.right = this._insertRec(node.right, key);

    return node;
  }

  postOrder() {
    const result = [];
    return this._postOrderRec(this.root, result);
  }

  _postOrderRec(node, result) {
    if (node) {
      this._postOrderRec(node.left, result);
      this._postOrderRec(node.right, result);
      result.push(node.key);
    }
    return result;
  }
}

function solution() {
  const bst = new BinarySearchTree();

  for (let i = 0; i < input.length; i++) {
    bst.insert(Number(input[i]));
  }

  console.log(bst.postOrder().join('\n'));
}

solution();