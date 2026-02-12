import java.io.*;
import java.util.*;

public class Solution
{
	private static int N;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	private static int[] dc = {0, 0, -1, 1};
	
	private static List<int[]> core; // 연결해야하는 코어 좌표 저장 (가장자리 코어는 저장 x)
	private static int totalCnt; // 연결된 코어 수
	private static int totalLen; // 전선 길이의 합
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			core = new ArrayList<>(); 
			totalCnt = 0;
			totalLen = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == N-1 || j == 0 || j == N-1) { // 가장자리 -> 연결된 것으로 처리
							totalCnt++; // 전선 길이는 0이므로 갯수만 업데이트
							continue;
						}
						// 연결해야 하는 코어 좌표(i,j) 저장
						core.add(new int[]{i, j});
					}
				}
			}
//			System.out.println("===============");
//			System.out.println(Arrays.deepToString(map));
//			for (int[] a: core) {
//				System.out.println(Arrays.toString(a));
//			}
			back(0, totalCnt, 0);
			sb.append("#").append(tc).append(" ").append(totalLen).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void back(int idx, int cnt, int sum) {
		if (idx == core.size()) { // 모든 코어 확인 완료
			if (cnt > totalCnt) {
	            totalCnt = cnt;
	            totalLen = sum;
	        } else if (cnt == totalCnt) {
	            totalLen = Math.min(totalLen, sum);
	        }
			return;
		}
		
		for (int i = 0; i < 4; i++) { // 현재 코어에서 4방 연결 시도
			if (canConnect(core.get(idx), i)){
				int len = toggle(core.get(idx), i); // 전선 연결
				back(idx+1, cnt+1, sum+len);
				toggle(core.get(idx), i); // 전선 삭제
			}
		}
		// 현재 코어 연결하지 않음
		back(idx+1, cnt, sum);
	}
	
	// 현재 코어에 전선 연결이 가능한지 확인
	public static boolean canConnect(int[] pos, int dir) {
		int r = pos[0], c = pos[1];
		r += dr[dir];
		c += dc[dir];
		while (r >= 0 && r < N && c >= 0 && c < N) {
			if (map[r][c] == 1) return false;
			r += dr[dir];
			c += dc[dir];
		}
		return true;
	}
	
	// 현재 코어에 전선을 연결 또는 삭제 (연결 가능한 상태이며, 연결이 되었거나 되지 않았음이 보장된 상태에서 사용)
	public static int toggle(int[] pos, int dir) {
		int r = pos[0], c = pos[1], len = 0;
		r += dr[dir];
		c += dc[dir];
		while (r >= 0 && r < N && c >= 0 && c < N) {
			map[r][c] ^= 1;
			len++;
			r += dr[dir];
			c += dc[dir];
		}
		return len;
	}
} 