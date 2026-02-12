import java.io.*;
import java.util.*;

public class Solution
{
	private static int N, rCnt, rNum; 
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			rCnt = Integer.MIN_VALUE; // 이동할 수 있는 방 최대 개수
			rNum = Integer.MAX_VALUE; // 이동할 수 있는 방의 개수가 최대일 때의 방 번호
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move(i, j);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(rNum).append(" ").append(rCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void move(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c, 1}); // 좌표 r, c, 노드 수
		int cnt = 0; // 이동한 방의 수
		
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			cnt = Math.max(cnt, pos[2]);
			
			for (int i = 0; i < 4; i++) {
				int nr = pos[0] + dr[i];
				int nc = pos[1] + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if (map[nr][nc] == map[pos[0]][pos[1]]+1) {
					q.add(new int[] {nr, nc, pos[2]+1});
					break;
				}
			}
		}
		
		if (cnt > rCnt) {
			rCnt = cnt;
			rNum = map[r][c];
		}
		else if (cnt == rCnt && rNum > map[r][c]) {
			rNum = map[r][c];
		}
	}
} 