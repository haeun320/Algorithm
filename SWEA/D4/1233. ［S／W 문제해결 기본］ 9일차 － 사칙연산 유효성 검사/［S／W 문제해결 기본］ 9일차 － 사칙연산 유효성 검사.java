
import java.io.*;
import java.util.*;

public class Solution
{
	public static Node[] tree;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			tree = new Node[N+1]; // 1-based
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken()); // 정점 번호
				String value = st.nextToken();
				tree[idx] = new Node(value);
				
				if (st.countTokens() > 0) {
					tree[idx].left = Integer.parseInt(st.nextToken());
				}
				if (st.countTokens() > 0) {
					tree[idx].right = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 1; // 계산이 가능한 것으로 초기화
			for (int i = 1; i <= N; i++) {
				// 리프노드인데 연산자인 경우 계산 불가
				if (tree[i].isLeafNode()) {
					String value = tree[i].value;
					if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
						result = 0;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static class Node {
		public String value;
		public int left = 0;
		public int right = 0;
		
		public Node(String value) {
			this.value = value;
		}
		
		public boolean isLeafNode() {
			return left == 0 && right == 0;
		}
	}
}
