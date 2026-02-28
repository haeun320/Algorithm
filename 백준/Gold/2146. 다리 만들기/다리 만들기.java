import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<List<Point>> startIdx;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of inputs
		
		// 섬 위치 마킹
		int idx = 2;
		startIdx = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					findIsland(i, j, idx++);
				}
			}
		}
		
//		printMap();
		
		// 섬-섬 다리 최단 길이 찾기
		int result = Integer.MAX_VALUE;
		int islandNum = 2;
		
		// 섬 위치를 마킹하면서 저장해둔 가장자리 좌표 사용 (2번 섬부터 차례대로 저장되어 있음)
		for (List<Point> arrRow: startIdx) {
			int n = findBridge(arrRow, islandNum++);
			result = Math.min(result, n);
		}
		
		System.out.println(result);
	}
	
	public static void findIsland(int r, int c, int idx) {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		List<Point> arrRow = new ArrayList<>();
		
		q.add(new Point(r, c));
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = idx;
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				// 섬의 가장자리 바다 도착
				if (map[nr][nc] == 0) {
					Point pos = new Point(nr, nc);
					arrRow.add(pos);
					continue;
				}
				
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));
			}
		}
		startIdx.add(arrRow);
	}
	
	
	public static int findBridge(List<Point> startPoints, int islandNum) {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		
		// 가장자리 좌표들을 모두 큐에 저장 
		for (Point p: startPoints) {
			q.add(new Point(p.r, p.c, 0));
			visited[p.r][p.c] = true;	
		}
		
		
		int bridgeLen = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			// 출발지와 다른 섬에 도착 시 다리 길이 업데이트 
			if (map[p.r][p.c] != islandNum && map[p.r][p.c] != 0) {
				bridgeLen = Math.min(bridgeLen, p.level);
				break; // 최단길이 발견 시 종료 
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				// 출발지 섬의 땅
				if (map[nr][nc] == islandNum) continue;
				
				// 바다 / 출발지가 아닌 섬
				else {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, p.level+1));
				}
			}
		}
		
		return bridgeLen;
	}

	public static void printMap() {
		System.out.println("========================");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("========================");
	}
	
	public static class Point{
		int r, c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		int level;
		Point(int r, int c, int l){
			this.r = r;
			this.c = c;
			this.level = l;
		}
	}
}
