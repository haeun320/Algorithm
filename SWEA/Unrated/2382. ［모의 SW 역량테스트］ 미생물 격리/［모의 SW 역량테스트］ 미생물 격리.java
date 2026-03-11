import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K; // 셀의 개수 N, 격리 시간 M, 미생물 군집의 개수 K
	static List<Cluster> clusters;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			clusters = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				clusters.add(new Cluster(r, c, cnt, dir));
			} // end of inputs
			
			// M 시간동안 시뮬레이션
			for (int i = 0; i < M; i++) {
				int[][] map = new int[N][N];
				int[][] dir = new int[N][N];
				
				Collections.sort(clusters); // 미생물 수 기준 오름차순 정렬

				// 이동
				int s = clusters.size();
				for (Cluster c: clusters) {
					c.move();
					map[c.r][c.c] += c.cnt;
					dir[c.r][c.c] = c.dir; // 미생물 수 기준 오름차순으로 정렬했으므로, 매번 저장하면 제일 큰 군집의 방향이 마지막으로 저장됨
				}
				
				// 같은 칸에 겹치는 군집 처리 
				List<Cluster> next = new ArrayList<>();
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] != 0) {
							next.add(new Cluster(r, c, map[r][c], dir[r][c]));
						}
					}
				}
				clusters = next;
			}
			
			// 결과 계산 
			int result = 0;
			for (Cluster c: clusters) {
				result += c.cnt;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean isValidPos(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static int reverseDir(int dir) {
	    if (dir == 0) return 1;
	    if (dir == 1) return 0;
	    if (dir == 2) return 3;
	    return 2;
	}
	
	static class Cluster implements Comparable<Cluster> {
		int r, c; // 좌표
		int cnt; // 미생물 수
		int dir; // 방향 (상하좌우)
		
		Cluster(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
		
		// return 이동 후 군집에 미생물이 남았는지 여부 
		boolean move() {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (!isValidPos(nr, nc)) return false; // 문제 설계 상 발생 X 
			r = nr;
			c = nc;
			
			if (r == 0 || r == N-1 || c == 0 || c == N-1) { // 약품 구역에 가면 
				dir = reverseDir(dir); 
				cnt /= 2; // 미생물절반 죽음
				
				if (cnt == 0) return false; // 남은 미생물 X
			}
			return true;
		}
		
		@Override
		public int compareTo(Cluster c) {
			return Integer.compare(cnt, c.cnt);
		}
	}
}
