import java.io.*;
import java.util.*;

public class Solution {
	static int N; // 섬의 수
	static double E; // 환경 부담 세율
	static Point[] points; // 섬 리스트
	static int[] parents; // union-find를 위한 루트 리스트
	static List<Edge> edges; // 간선 리스트 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); 
			points = new Point[N];
			int[] xs = new int[N];
			int[] ys = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) xs[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) ys[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
			    points[i] = new Point(xs[i], ys[i]);
			}
			
			E = Double.parseDouble(br.readLine()); // end of inputs
			
			// 모든 간선 정보 저장
			edges = new ArrayList<>();
			for (int i = 0; i < N-1; i++) { // 정점 두개 선택 
				for (int j = i+1; j < N; j++) {
					double cost = getDistance(points[i], points[j]);
					edges.add(new Edge(i, j, cost));
				}
			}
			
			// 간선 비용 기준 오름차순 정렬
			Collections.sort(edges);
			
			makeSet(); // parents 초기화
			
			// 간선 비용 낮은것부터 선택
			double result = 0; // 환경 부담 세율 누적 
			int cnt = 0; // 선택된 간선의 수
			for (Edge edge: edges) {
				if (union(edge.start, edge.end)) {
					result += E * edge.cost;
					if (++cnt == N-1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static double getDistance(Point p1, Point p2) {
		// 거리 공식: 루트( (by-ay)^2 + (bx-ax)^2 )
		// 결과값에서 비용의 제곱을 사용할 것이므로, 루트 생략 
		double xd = Math.pow(p2.y - p1.y, 2);
		double yd = Math.pow(p2.x - p1.x, 2);
		return xd + yd;
	}
	
	static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if (fa == fb) return false; // 같은 집합 내의 노드를 연결하면 사이클이 생긴다 
		
		parents[fa] = fb;
		return true;
	}
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start, end;
		double cost;
		Edge(int s, int e, double c){
			start = s;
			end = e;
			cost = c;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.cost, e.cost);
		}
	}
}
