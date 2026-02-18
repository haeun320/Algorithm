import java.util.*;
import java.io.*;


public class Main {
	static int N, M, K, result; // 행, 열, 연산 개수, 최종 출력값
	static int[][] originMap;
	static Operation[] opr; // 연산 저장
	static boolean[] isSelected; // 순열만들때 해당 인덱스 선택 여부 저장
	static int[] selectedIdx; // 순열 결과 opr 인덱스 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		originMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		opr = new Operation[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			opr[i] = new Operation(r-1, c-1, s);
		} // end of inputs
		
		// 연산 순열 => 배열 회전 => 배열값 구하기 
		isSelected = new boolean[K];
		selectedIdx = new int[K];
		result = 1234567890;
		perm(0);
		System.out.println(result);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	
	public static void printMap(int[][] map) {
		System.out.println("=================");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	// cnt: 선택된 요소 개수 
	public static void perm(int cnt) {
		if (cnt == K) {
			int[][] tmpMap = new int[N][];
			for (int i = 0; i < N; i++) {
				tmpMap[i] = originMap[i].clone();
			}
			// 선택된 연잔자 순서대로 배열 회전
			for (int i = 0; i < K; i++) {
				int idx = selectedIdx[i];
//				System.out.println(opr[idx].toString());
				turn(opr[idx].r, opr[idx].c, opr[idx].s, tmpMap);
//				printMap(tmpMap);
			}
			
			// 배열 값 구하기
			result = Math.min(result, calValue(tmpMap));
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			selectedIdx[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static int calValue(int[][] map) {
		int min = 1234567890;
		for (int i = 0; i < N; i++) {
			int cal = 0;
			for (int j = 0; j < M; j++) {
				cal += map[i][j];
			}
			min = Math.min(min, cal);
		}
		return min;
	}
	
	public static int[][] turn(int r, int c, int s, int[][] map) {
		// 제일 안쪽부터 차례로 회전 (총 s번)
		for (int i = 1; i <= s; i++) {
			// 좌상단부터 역순으로 회전 처리 시작
			int nr = r - i;
			int nc = c - i;
			int tmp = map[nr][nc]; // 좌상단 값은 임시 저장
			
			// 아래로 이동 
			while (nr >=  r-i && nr < r+i) {
				map[nr][nc] = map[nr+1][nc];
				nr++;
			}
			// 오른쪽으로 이동
			while (nc >= c-i && nc < c+i) {
				map[nr][nc] = map[nr][nc+1];
				nc++;
			}
			// 위로 이동 
			while (nr > r-i && nr <= r+i) {
				map[nr][nc] = map[nr-1][nc];
				nr--;
			}
			// 왼쪽으로 이동
			while (nc > c-i+1 && nc <= c+i) {
				map[nr][nc] = map[nr][nc-1];
				nc--;
			}
			map[nr][nc] = tmp;
		}
		return map;
	}
	
	public static class Operation {
		int r, c, s;

		public Operation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
		@Override
		public String toString() {
			return "r: "+(r+1)+", c: "+(c+1)+", s: "+s;
		}
	}
}
