/*
배열을 이용한 트리 구조로 상호배타적 집합 구현

- 인덱스: 노드 번호
- 값: 부모 노드 번호 (-1은 노드 없음, 루트는 자기 자신을 가리킴)

tree = [0, -1, 3, 3, 5, 3, 5]

    3
   / \
  2   5
     / \
    4   6
*/

// 집합의 루트 노드 찾기
function find(parents, x) {
  // x가 루트 노드일 때
  if (parents[x] === x) {
    return x;
  }

  // 경로 압축
  parents[x] = find(parents, parents[x]);
  return parents[x];
}

// 두 개의 상호배타적 집합을 하나로 합치기
function union(parents, x, y) {
  const root1 = find(parents, x); // x가 속한 집합의 루트 노드 찾기
  const root2 = find(parents, y); // y가 속한 집합의 루트 노드 찾기

  parents[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
}

function solution(k, operations){
  // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
  const parents = Array.from({length: k}, (_, i) => i);
  let n = k; // 집합의 개수를 저장할 변수. 처음에는 모든 노드가 서로 다른 집합에 있으므로 k

  for (const op of operations) {
    if (op[0] === 'u') {
      union(parents, op[1], op[2]);
    }
    else if (op[0] === 'f') {
      find(parents, op[1]);
    }

    // 모든 노드의 루트 노드를 찾아서 집합의 개수를 계산
    n = new Set(Array.from({length: k}, (_,i) => find(parents, i))).size;
  }

  return n;
}

const k = 3;
const operations = [['u', 0, 1], ['u', 1, 2], ['f', 2]];

console.log(solution(k, operations));
