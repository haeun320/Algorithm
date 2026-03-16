import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int start, end;
		int cost;
		
		Node(int s, int e, int c){
			start = s;
			end = e;
			cost = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}
	}
	
	static int N, M, X; // 도시 번호 1번부터 시작 
	static List<List<Node>> graph;
	static int[] dist;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		dist = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(start, end, cost));
		}
		
		dijkstra(X);
		int[] roundDist = new int[N+1];
		for (int i = 1; i <= N; i++) {
			roundDist[i] = dist[i];
		}
		
		for (int i = 1; i <= N; i++) {
			if (i != X) {
				dijkstra(i);
				roundDist[i] += dist[X];
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (roundDist[i] > max) max = roundDist[i];
		}
		System.out.println(max);
	}
	
	static void dijkstra(int node) {
		for (int i = 0; i < N+1; i++) {
			dist[i] = INF;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[node] = 0;
		pq.add(new Node(node, node, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			for (Node next: graph.get(curr.end)) {
				if (dist[next.end] > dist[next.start] + next.cost) {
					dist[next.end] = dist[next.start] + next.cost;
					pq.add(next);
				}
			}
		}
	}
}
