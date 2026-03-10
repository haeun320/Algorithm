import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int result;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][];
			visited = new boolean[N][N];
			result = 0;
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 0 연쇄적으로 사라지는 칸 확인 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '*') continue;
					
					// 아직 지뢰 수 세지 않은 칸에서, 지뢰가 없는 칸일때 
					if (!visited[i][j] && cntMap(i, j) == 0) {
						bfs(i, j);
						result++;
					}
				}
			}
			
			// 남은 칸은 한번씩 클릭
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] == '.') {
						result++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int vr = node[0];
			int vc = node[1];
			
			int count = cntMap(vr, vc);
			
			if (count == 0) {
				for (int i = 0; i < 8; i++) {
					int nr = vr + dr[i];
					int nc = vc + dc[i];
					if (!isValidPos(nr, nc)) continue;
					if (visited[nr][nc]) continue;
					q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	// 지뢰 (*) 개수 세기 
	static int cntMap(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!isValidPos(nr, nc)) continue;
			if (map[nr][nc] == '*') cnt++;
		}
		return cnt;
	}
	
	static boolean isValidPos(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
