import java.io.*;
import java.util.*;

public class Main {
	static int N, M, maxVal;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of inputs
		
		// 완전탐색
		maxVal = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(0, 0, i, j);
			}
		}
		System.out.println(maxVal);
	}
	
	/**
	 * 
	 * @param cnt 현재 선택한 칸의 수 
	 * @param sum 현재까지 선택된 칸에 쓰여있는 수의 합 
	 * @param r 현재 칸의 row 
	 * @param c 현재 칸의 col 
	 */
	public static void dfs(int cnt, int sum, int r, int c) {
		if (cnt == 4) {
			maxVal = Math.max(maxVal, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if (visited[nr][nc]) continue;
			
			if (cnt == 2) { // ㅜ모양 처리를 위해, 기준점 옮기지 않고 재귀 호출
				visited[nr][nc] = true;
				dfs(cnt+1, sum+map[nr][nc], r, c);
				visited[nr][nc] = false;
			}
			
			visited[nr][nc] = true;
			dfs(cnt+1, sum+map[nr][nc], nr, nc);
			visited[nr][nc] = false;
		}
	}
}

/**
 * 테트로미노 하나를 N*M	종이 위에 놓기 -> 놓인 칸의 수 합이 최대
 * 회전/대칭 가능
 * 
 * dfs로 4개의 칸 수의 합을 구한다
 * ㅜ모양은 dfs로 안됨 -> cnt == 2일때 기준점을 옮기지 않고 재귀호출해서 해결 
 */