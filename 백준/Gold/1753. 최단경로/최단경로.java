import java.io.*;
import java.util.*;

public class Main{
	static int V, E;
	static int K;
	static List<List<Node>> graph;
	static int[] d;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		// 그래프 인접리스트 초기화
		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 최단경로 테이블 최댓값으로 초기화
		d = new int[V+1];
		Arrays.fill(d, INF);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			sb.append(d[i] == INF ? "INF" : d[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			if (n.cost > d[n.index]) continue;
			
			for (Node next: graph.get(n.index)) {
				int nextCost = d[n.index] + next.cost;
				if (d[next.index] > nextCost) {
					d[next.index] = nextCost;
					pq.add(new Node(next.index, nextCost));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node> {
		int index;
		int cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}