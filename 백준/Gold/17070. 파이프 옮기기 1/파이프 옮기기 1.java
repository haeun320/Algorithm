import java.util.*;
import java.io.*;


public class Main {
	static int N; // 집의 크기 3 ≤ N ≤ 16
	static int[][] map; // 빈칸 0, 벽 1 
	static int result;
	static int[][][] memo; // memo[row][col][가로/대각선/세로 파이프]의 경로 개수 저장 
	
	// 방향 우, 우하, 하
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo = new int[N][N][3];
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        Arrays.fill(memo[i][j], -1);
		    }
		}
		
		result = dfs(0, 1, 0);
		System.out.println(result);
	}
	
	static int dfs(int r, int c, int dir){
	    if (r == N-1 && c == N-1) return 1;
	    if (memo[r][c][dir] != -1) return memo[r][c][dir];

	    int cnt = 0;

	    // 0:가로 -> 우(0), 대각(1)
	    if (dir == 0 || dir == 1) {
	        int nr = r, nc = c+1;
	        if (nc < N && map[nr][nc] == 0) cnt += dfs(nr, nc, 0);
	    }

	    // 2:세로 -> 하(2), 대각(1)
	    if (dir == 2 || dir == 1) {
	        int nr = r+1, nc = c;
	        if (nr < N && map[nr][nc] == 0) cnt += dfs(nr, nc, 2);
	    }

	    // 대각(1)은 누구든 가능 (단 3칸 비어야)
	    int nr = r+1, nc = c+1;
	    if (nr < N && nc < N && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0) {
	        cnt += dfs(nr, nc, 1);
	    }

	    return memo[r][c][dir] = cnt;
	}
}
