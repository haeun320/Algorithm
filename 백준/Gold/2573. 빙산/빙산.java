import java.util.*;
import java.io.*;

public class Main {
	static int N, M; // map 크기 
	static int[][] map;
	static boolean[][] visited;
	static List<Point> iceberg;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		iceberg = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value != 0) {
					iceberg.add(new Point(i, j, value));
				}
			}
		} // end of inputs
		
		int year = 0;
		
		loop:
		while (true) { // 빙산이 두 덩이가 될때까지 반복
			// 빙산 녹이기 
			melt();
			year++;
			
			// 전부 다 녹을때까지 두 덩어리로 분리되지 않음 
			if (iceberg.isEmpty()) {
		        year = 0;
		        break loop;
		    }
			
//			printMap();
			
			// 빙산 덩어리 체크
			visited = new boolean[N][M];
			bfs(iceberg.get(0).r, iceberg.get(0).c); // 저장된 첫번째 빙산 좌표 사용 
			
			// 빙산 좌표가 다 방문되었는지 확인 
			for (Point p: iceberg) {
				if (!visited[p.r][p.c]) break loop; // 방문되지 않은 빙산이 있다 -> 두 덩어리로 쪼개졌다.
			}
		}
		
		System.out.println(year);
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if (!isValidPos(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				if (map[nr][nc] != 0) {
					q.add(new Point(nr, nc));
				}
			}
		}
		
	}
	
	public static void melt() {
		// 녹은 빙산의 높이 저장
		for (int i = 0; i < iceberg.size(); i++) {
			Point p = iceberg.get(i);
			// 상하좌우 바다 확인
			int cnt = 0;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if (!isValidPos(nr, nc)) continue;
				if (map[nr][nc] == 0) cnt++;
			}
			
			// 바다 개수만큼 감소시킬 빙산 높이 저장
			p.value = p.value > cnt ? p.value - cnt : 0; 
			iceberg.set(i, p);
		}
		
		// 변경된 빙산의 높이 map에 반영 및 다 녹은 빙산 정리 
		for (int i = iceberg.size()-1; i >= 0; i--) {
			Point p = iceberg.get(i);
			map[p.r][p.c] = p.value;
			
			if (p.value == 0) { // 빙산 다 녹았으면 삭제처리 
				iceberg.remove(i);
			}
			
		}
		
	}
	
	public static boolean isValidPos(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
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
		int value;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		Point(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.value = n;
		}
	}
}
