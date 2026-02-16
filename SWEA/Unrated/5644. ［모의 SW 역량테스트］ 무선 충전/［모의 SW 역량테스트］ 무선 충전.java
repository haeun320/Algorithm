import java.io.*;
import java.util.*;

/**
 * 1. 입력 처리 
 * 문제에서 제시하는 좌표를 코드 짜기 편하게 변환한다
 * 문제 좌표 (c, r) 1-based ==> 코드 상의 좌표 (r, c) 0-based
 * 
 * BC[] bc 배열에 입력받은 순서대로 BC 정보를 저장한다. 최대 개수는 8이다.
 * 
 * 2. 충전 범위 저장 
 * 10*10 크기의 map을 순회하면서, 각 좌표별로 접속이 가능한 bc를 저장한다. 
 * 거리(|r1-r2|+|c1-c2|)가 bc의 충전 범위 이하일 때 접속이 가능하다.
 * bc는 최대 8개이므로, 비트마스킹을 사용해 접속 가능 여부를 저장한다(1: 접속 가능, 0: 접속 불가능)
 * 
 * 3. 사용자 이동 시뮬레이션
 * M만큼 반복하면서 사용자를 이동시킨다.
 * 이동한 위치에서 접속 가능한 bc를 확인한다.
 * 두 사용자의 접속 가능 bc 목록으로, 각자 1개씩 뽑는 조합 완전탐색 ==> 최대 충전량 저장 
 * 
 */

public class Solution {
	static int M, A; // 이동시간 M, BC개수 A
	static int[] moveA, moveB; // 사용자 A, B의 이동 정보 
	static BC[] bc; // 1 <= BC 개수 <= 8
	static int[][] map; // 해당 위치 좌표에서 접속 가능한 BC 번호를 비트마스킹(0000 0000 ~ 1111 1111)으로 저장한다. 
	
	static Point pa;
	static Point pb;
	
	// 제자리, 상, 우, 하, 좌 
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static int MAP_SIZE = 10;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			// M, A 입력 
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			// 이동 정보 입력 
			moveA = new int[M];
			moveB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC 정보 입력 
			bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken()) - 1; // 문제 좌표 (c, r) 1-based ==> 코드 상의 좌표 (r, c) 0-based
				int row = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bc[i] = new BC(row, col, c, p);
			}
			
			// 사용자 위치 초기화
			pa = new Point(0, 0);
			pb = new Point(MAP_SIZE-1, MAP_SIZE-1);
			
			// map에 접속 가능 bc 번호 저장
			initializeMap();
			
			// 사용자의 초기 위치(0초)부터 충전을 할 수 있다.
			int result = calPower();
			
			
			// 사용자 이동 시뮬레이션 
			for (int i = 0; i < M; i++) {
				pa.move(moveA[i]);
				pb.move(moveB[i]);
				
				// 이동된 위치에서 최대 충전량 구하기 
				result += calPower();
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void initializeMap() {
		// 완전탐색 최대 10 * 10 * 8 = 800번 연산 
		map = new int[MAP_SIZE][MAP_SIZE];
		for (int i = 0; i < MAP_SIZE; i++) {
			for (int j = 0; j < MAP_SIZE; j++ ) {
				// bc 순회
				for (int b = 0; b < A; b++) {
					int dist = Math.abs(i - bc[b].row) + Math.abs(j - bc[b].col);
					if (dist <= bc[b].c) 
						map[i][j] |= (1 << b);
				}
				
			}
		}
	}
	
	public static int calPower() {
	    int max = 0;

	    List<Integer> aList = pa.getAvailableBC();
	    List<Integer> bList = pb.getAvailableBC();
	    aList.add(-1);
	    bList.add(-1);

	    for (int ba : aList) {
	        for (int bb : bList) {
	            int sum = 0;

	            if (ba == -1 && bb == -1) sum = 0;
	            else if (ba == -1) sum = bc[bb].p;
	            else if (bb == -1) sum = bc[ba].p;
	            else if (ba == bb) sum = bc[ba].p;          // 같은 BC면 나눠서 결국 그 BC의 p
	            else sum = bc[ba].p + bc[bb].p;

	            max = Math.max(max, sum);
	        }
	    }
	    return max;
	}
	
	public static class BC{
		int row, col; // 좌표 
		int c; // 충전 범위 (거리: |r1-r2|+|c1-c2|)
		int p; // 성능 (충전량)
		
		BC(int row, int col, int c, int p){
			this.row = row;
			this.col = col;
			this.c = c;
			this.p = p;
		}
	}
	
	public static class Point{
		int r, c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		public void move(int dir) {
			// 지도 밖으로 이동하는 경우는 없다. 
			this.r += dr[dir];
			this.c += dc[dir];
		}
		
		public List<Integer> getAvailableBC() {
			int mask = map[r][c];
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				if ((mask & (1 << i)) != 0) {
					arr.add(i);
				}
			}
			return arr;
		}
	}
}