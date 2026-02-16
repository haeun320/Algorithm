import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static Node[] students;
	static boolean[] isCounted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine()); // 학생 수 
        	M = Integer.parseInt(br.readLine()); // 키 비교 횟수 
        	students = new Node[N+1]; // 1번부터 사용
        	for (int i = 1; i <= N; i++) {
        		students[i] = new Node(i);
        	}
        	
        	for (int i = 0; i < M; i++) {
         		// a인 학생 키 < b 학생 키 ==> a.child = b; b.parent = a;
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		students[a].addChild(students[b]);
        		students[b].addParent(students[a]);
         	}
        	
        	int result = 0;
        	// 자신의 부모 수 + 자식 수 = N-1 이면 본인 순서 유추 가능
        	for (int i = 1; i <= N; i++) {
        		isCounted = new boolean[N+1];
        		int p = getParentCnt(students[i]);
        		isCounted = new boolean[N+1];
        		int c = getChildCnt(students[i]);
        		if (p + c == N-1) {
        			result++;
        		}
        	}
            
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int getParentCnt(Node n) {
    	if (n.parent.isEmpty()) {
    		isCounted[n.n] = true;
    		return 0;
    	}
    	if (isCounted[n.n]) return 0;
    	
    	isCounted[n.n] = true;
    	
    	int cnt = 0;
    	for (Node p : n.parent) {
    		if (isCounted[p.n]) continue;
    		cnt += getParentCnt(p) + 1;
    	}
    	
    	return cnt;
    }
    
    public static int getChildCnt(Node n) {
    	if (n.child.isEmpty()) {
    		isCounted[n.n] = true;
    		return 0;
    	}
    	if (isCounted[n.n]) return 0;
    	
    	isCounted[n.n] = true;
    	
    	int cnt = 0;
    	for (Node c : n.child) {
    		if (isCounted[c.n]) continue;
    		cnt += getChildCnt(c) + 1;
    		isCounted[c.n] = true;
    	}
    	
    	return cnt;
    }
    
    public static class Node{
    	List<Node> parent;
    	List<Node> child;
    	int n; // 학생 번호 
    	
    	Node(){
    		this.parent = new ArrayList<>();
    		this.child = new ArrayList<>();
    	}
    	Node(int n){
    		this.parent = new ArrayList<>();
    		this.child = new ArrayList<>();
    		this.n = n;
    	}
    	
    	public void addParent(Node n) {
    		parent.add(n);
    	}
    	
    	public void addChild(Node n) {
    		child.add(n);
    	}
    	
    	public String tostring() {
    		return Integer.toString(n);
    	}
    }
}