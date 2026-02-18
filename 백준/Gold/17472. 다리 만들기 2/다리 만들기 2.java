import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	
	static int islandCnt;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static List<Edge> edges;
	static int[] parent; // 유니온파인드 
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. map에 섬 번호 칠하기
		islandCnt = 0;
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || map[i][j] == 0) continue;
				bfs(i, j);
				islandCnt++;
			}
		}
//		printMap(map);
		
		// 2. 섬에서 섬으로 가는 최소 다리 길이 구하기
		edges = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) continue;
				findBridge(i, j, map[i][j]);
			}
		}
		
		// 3. 크루스칼 알고리즘 - 간선 가중치 최소 합 구하기 
		edges.sort(null); // 가중치 기준 오름차순 정렬
//		for (int i = 0; i < edges.size(); i++) {
//			System.out.println(edges.get(i).toString());
//		}
		parent = new int[islandCnt+1];
		for (int i = 1; i <= islandCnt; i++) {
			parent[i] = i;
		}
		
		int cnt = 0, result = 0;
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				cnt++;
				result += e.weight;
			}
		}
		
		System.out.println(cnt == islandCnt-1 ? result : -1);
	}
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		parent[pa] = pb;
		return true;
	}
	
	// 좌표 r, c, 섬 번호 n
	public static void findBridge(int r, int c, int from) {
		// 4방향으로 다리 놓기 시도
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			int cnt = 0;
			int to = -1;
			
			while (true) {
				nr += dr[i];
				nc += dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) break; // 범위 밖
				if (map[nr][nc] == from) break; // 자신의 섬 영토
				
				if (map[nr][nc] != 0) { // 다른 섬 영토
					to = map[nr][nc];
					break;
				}
				
				cnt++;
			}
			
			if (cnt < 2 || to == -1) continue;
			edges.add(new Edge(from, to, cnt));
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		int num = islandCnt + 1;
		
		q.add(new int[] {r, c});
		visited[r][c] = true;
		map[r][c] = num;
		
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int vr = p[0];
			int vc = p[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = vr + dr[i];
				int nc = vc + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc] || map[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				map[nr][nc] = num;
			}
		}
	}
	
	public static void printMap(int[][] map) {
		System.out.println("===================");
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	public static class Edge implements Comparable<Edge> {
		int from, to, weight;
		Edge(int f, int t, int w){
			this.from = f;
			this.to = t;
			this.weight = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
		public String toString() {
			return this.from + " " + this.to + " " + this.weight;
		}
		
	}
}