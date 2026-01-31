import java.io.*;
import java.util.*;

public class Main {
	public static char[][] map = new char[5][5];
	public static boolean[][] selected = new boolean[5][5]; // combination
	public static int result = 0;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		combination(0, 0, 0);
		System.out.println(result);
	}
	
	// idx번 칸부터 탐색 시작, 현재 뽑은 수 cnt, 이다솜파 학생 수 sCnt
	public static void combination(int idx, int cnt, int sCnt) {
		if (cnt == 7) {
			if (sCnt >= 4) {
				if (bfs()) {
					result++;
				}
			}
		}
		
		for (int i = idx; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			
			selected[r][c] = true;
			combination(i+1, cnt+1, sCnt+(map[r][c] == 'S' ? 1 : 0));
			selected[r][c] = false;
		}
	}
	
	// 7명 인접한지 확인
	public static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		
		int sr = 0, sc = 0;
		
		fr:
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (selected[i][j]) {
					sr = i;
					sc = j;
					break fr;
				}
			}
		}
		
		q.add(new int[] {sr, sc});
		visited[sr][sc] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
					continue;
				if (selected[nr][nc] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
					cnt++;
				}
			}
		}
		
		// 모두 연결되면 true 반환
		return cnt == 7;
	}
}
