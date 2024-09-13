class TreeNode {
  constructor(key) {
    this.key = key;
    this.left = null;
    this.right = null;
  }
}

class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  // -------------------------- INSERT --------------------------
  insert(key) {
    this.root = this._insertRec(this.root, key);
  }

  _insertRec(node, key) {
    // 노드가 비어있으면 -> 해당 노드에 삽입
    if (!node) {
      return new TreeNode(key);
    }
    
    // 삽입하려는 값이 현재 노드보다 작을 때 -> 왼쪽 노드로 이동
    if (key < node.key) {
      node.left = this._insertRec(node.left, key);
    } 
    // 삽입하려는 값이 현재 노드보다 클 때 -> 오른쪽 노드로 이동
    else if (key > node.key) {
      node.right = this._insertRec(node.right, key);
    }
    
    return node;
  }

  // -------------------------- DELETE --------------------------
  delete(key) {
    this.root = this._deleteRec(this.root, key);
  }

  _deleteRec(node, key) {
    if (!node) {
      return null;
    }
    
    if (key < node.key) {
      node.left = this._deleteRec(node.left, key);
    } 
    else if (key > node.key) {
      node.right = this._deleteRec(node.right, key);
    } 
    // 삭제 로직
    else {
      // 자식 노드가 하나만 있거나 없을 때
      if (!node.left) {
        return node.right;
      } 
      else if (!node.right) {
        return node.left;
      }
      
      // 자식 노드가 두개 모두 존재할 때
      // 후위계승자를 이용한 삭제
      let minNode = this._getMinNode(node.right);
      node.key = minNode.key; // 삭제할 키를 후위계승자로 덮어쓰기
      node.right = this._deleteRec(node.right, minNode.key); // 후위계승자 삭제

      // 전위계승자를 이용한 삭제
      // let maxNode = this._getMaxNode(node.left);
      // node.key = maxNode;
      // node.left = this._deleteRec(node.left, maxNode.key);
    }
    
    return node;
  }

  // 후위계승자: 오른쪽 서브트리에서 제일 작은 값
  _getMinNode(node) {
    let current = node;
    while (current.left) {
      current = current.left;
    }
    return current;
  }

  // 전위계승자: 왼쪽 서브트리에서 제일 큰 값
  _getMaxNode(node) {
    let current = node;
    while (current.right) {
      current = current.right;
    }
    return current;
  }

  // -------------------------- 전위순회 --------------------------
  // 전위순회: 부모 -> 왼쪽 -> 오른쪽
  preOrder() {
    return this._preOrderRec(this.root);
  }

  _preOrderRec(node) {
    if (node) {
      return `[${node.key}] ${this._preOrderRec(node.left)}${this._preOrderRec(node.right)}`;
    }
    return '';
  }

  // -------------------------- 중위순회 --------------------------
  // 중위순회: 왼쪽 -> 부모 -> 오른쪽
  inOrder() {
    return this._inOrderRec(this.root);
  }

  _inOrderRec(node) {
    if (node) {
      return `${this._inOrderRec(node.left)}[${node.key}] ${this._inOrderRec(node.right)}`;
    }
    return '';
  }

  // -------------------------- 후위순회 --------------------------
  // 후위순회: 왼쪽 -> 오른쪽 -> 부모
  postOrder() {
    return this._postOrderRec(this.root);
  }

  _postOrderRec(node) {
    if (node) {
      return `${this._postOrderRec(node.left)}${this._postOrderRec(node.right)}[${node.key}] `;
    }
    return '';
  }


  print(msg, key) {
    console.log(`[${msg} ${key.toString().padStart(2)}] : ${this.preOrder()}`);
  }
}

function solution(){
  const bst = new BinarySearchTree();

  const data = [35, 18, 7, 26, 3, 22, 30, 12, 26, 68, 99];
  
  for (let i = 0; i < data.length; i++) {
    bst.insert(data[i]);
    bst.print("Insert", data[i]);
  }
  
  console.log();
  
  bst.delete(18);
  bst.print("Delete", 18);

  console.log("preOrder :", bst.preOrder());
  console.log("inOrder :", bst.inOrder());
  console.log("postOrder :", bst.postOrder());
}

solution();