import java.io.*;
import java.util.*;

public class Solution
{
	private static int N, rCnt, rNum; 
	private static int[][] map, memo;
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
			memo = new int[N][N]; // 현재 방에서 출발했을 때 이동할 수 있는 방의 최대 개수
			
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
					int cnt = move(i, j);
					
					if (cnt > rCnt) {
						rCnt = cnt;
						rNum = map[i][j];
					}
					else if (cnt == rCnt) { // 이동할 수 있는 방의 개수가 같으면 더 작은 방 번호 선택
						rNum = Math.min(rNum, map[i][j]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(rNum).append(" ").append(rCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int move(int r, int c) {
		if (memo[r][c] != 0) return memo[r][c];
		
		memo[r][c] = 1; // 자기 자신에서 출발 -> 1칸 감
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            
            // 현재 방보다 1 커지면 이동 가능
            if (map[nr][nc] == map[r][c] + 1) {
            	memo[r][c] += move(nr, nc);
            	break;
            }
		}
		
		return memo[r][c]; // (r,c)에서 출발해서 갈 수 있는 방의 개수 리턴
	}
} 