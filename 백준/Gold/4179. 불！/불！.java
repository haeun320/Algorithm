import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static char[][] map;
	static Point J; // 지훈 좌표
	static Deque<Point> fire;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		fire = new ArrayDeque<>();
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'J') {
					J = new Point(i, j);
				}
				else if (map[i][j] == 'F') {
					fire.add(new Point(i, j));
				}
			}
		} // end of inputs
		
		
		// 매 분마다 불 먼저 확산 후 지훈 이동
		visited = new boolean[R][C];
		int result = bfs();
		
		System.out.println(result > 0 ? result : "IMPOSSIBLE");
	}
	
	// 지훈이 탈출 가능한 가장 빠른 시각 반환
	public static int bfs() {
		Queue<Point> q = new ArrayDeque<>();
		J.level = 0;
		q.add(J);
		visited[J.r][J.c] = true;
		int curMin = J.level - 1; // 현재 분
		
		while (!q.isEmpty()) {
			Point p = q.poll();
//			System.out.println(p.toString());
			// 분 바뀌면 불 확산시키기
			if (curMin != p.level) {
				spreadFire();
				curMin = p.level;
			}
			
//			printMap();
			
			// 지훈 이동
			for (int i = 0; i < 4; i++) {
				int r = p.r + dr[i];
				int c = p.c + dc[i];
				
				// 지훈이 미로 밖 도달 -> 탈출 가능
				if (!isValidPos(r, c)) {
					return p.level + 1;
				}
				
				if (visited[r][c]) continue;
				if (map[r][c] == '#' || map[r][c] == 'F') continue;
				
				visited[r][c] = true;
				q.add(new Point(r, c, p.level + 1));
			}
		}
		
		return -1;
	}
	
	public static void spreadFire() {
		int size = fire.size();
		for (int j = 0; j < size; j++) {
			Point f = fire.pollFirst();
			for (int i = 0; i < 4; i++) {
				int r = f.r + dr[i];
				int c= f.c + dc[i];
				if (!isValidPos(r, c)) continue;
				if (map[r][c] == '#' || map[r][c] == 'F') continue;
				map[r][c] = 'F';
				fire.addLast(new Point(r, c));
			}
		}
	}
	
	public static boolean isValidPos(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	public static void printMap() {
		System.out.println("=====================");
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	public static class Point{
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		int level; // for bfs
		Point(int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.level = l;
		}
		public String toString() {
			return r + " " + c + " " + level;
		}
	}
}
