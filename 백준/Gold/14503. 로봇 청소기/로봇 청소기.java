import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map; // 0: 청소 x, 1: 벽, 2: 청소 o
	static Point vacuum;
	
	// 방향 상, 우, 하, 좌 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		vacuum = new Point(r, c, d);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of inputs
		
		int result = 0;
		
		while (true) {
			if (vacuum.clean()) result++;
			
			if (!vacuum.hasUncleanAdj()) {
				if (!vacuum.back()) break;
				continue;
			}
			else {
				vacuum.turn();
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isValidPos(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	public static class Point{
		int r, c;
		int dir;
		Point(int r, int c, int dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		// 현재 칸이 청소되지 않으면 청소 후 true 반환
		public boolean clean() {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				return true;
			}
			return false;
		}
		
		// 인접한 칸에 청소되지 않은 칸이 있는지 확인
		public boolean hasUncleanAdj() {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (!isValidPos(nr, nc)) continue;
				if (map[nr][nc] == 0) {
					return true;
				}
			}
			return false;
		}
		
		// 후진 가능하면 후진 후 true 반환
		public boolean back() {
			int backDir = dir >= 2 ? dir - 2 : dir + 2;
			int nr = r + dr[backDir];
			int nc = c + dc[backDir];
			
			if (!isValidPos(nr, nc) || map[nr][nc] == 1)
				return false;
			
			this.r = nr;
			this.c = nc;
			return true;
		}
		
		// 반시계방향 90도 회전 -> 앞 칸 비어있으면 전진
		public void turn() {
			this.dir = (4 + dir - 1) % 4;
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if (!isValidPos(nr, nc) || map[nr][nc] != 0)
				return;
			
			this.r = nr;
			this.c = nc;
		}
	}
}
