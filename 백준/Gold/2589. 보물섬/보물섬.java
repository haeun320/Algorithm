import java.util.*;
import java.io.*;

public class Main {
	static int N, M; // N, M <= 50
	static char[][] map;
	
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		} // end of inputs
		
		// 격자 최대 50 * 50 = 2500 --> 브루트포스
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'W') continue;
				result = Math.max(result, bfs(i, j));
			}
		}
		
		System.out.println(result);
	}
	
	public static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
		
		q.add(new int[] {r, c, 0});
		visited[r][c] = true;
		
		int result = 0;
		
		while (!q.isEmpty()) {
			int nr = q.peek()[0];
			int nc = q.peek()[1];
			int nl = q.poll()[2];
			result = Math.max(result, nl);
			
			for (int i = 0; i < 4; i++) {
				int vr = nr + dr[i];
				int vc = nc + dc[i];
				
				if (vr < 0 || vr >= N || vc < 0 || vc >= M) continue;
				if (visited[vr][vc]) continue;
				if (map[vr][vc] == 'W') continue;
				
				q.add(new int[] {vr, vc, nl+1});
				visited[vr][vc] = true;
			}
		}
		
		return result;
	}
}
