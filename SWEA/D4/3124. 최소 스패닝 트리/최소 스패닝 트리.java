import java.io.*;
import java.util.*;

public class Solution {
	static int V, E;
	static Edge[] edges;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); 
			E = Integer.parseInt(st.nextToken());
			
			edges = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(a, b, c);
			}
			
			makeSet();
			Arrays.sort(edges);
			
			int cnt = 0;
			long result = 0;
			for (Edge edge: edges) {
				if (union(edge.start, edge.end)) {
					result += edge.cost;
					if (++cnt == V-1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if (fa == fb) return false;
		
		parents[fa] = fb;
		return true;
	}
	
	static void makeSet() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start, end, cost;
		Edge(int s, int e, int c){
			start = s;
			end = e;
			cost = c;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(cost, e.cost);
		}
	}
}
