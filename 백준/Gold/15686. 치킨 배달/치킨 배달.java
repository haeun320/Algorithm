import java.io.*;
import java.util.*;

public class Main {
	static int N, M, minDist;
	static int[][] map;
	static List<Point> houses;
	static List<Point> chickens;
	static boolean[] isSelected; // 치킨집 조합 선택 여부 저장 
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		minDist = 1234567890;
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 치킨집, 집 좌표 저장
				switch (map[i][j]) {
				case 1:
					houses.add(new Point(i, j));
					break;
				case 2:
					chickens.add(new Point(i, j));
					break;
				}
			}
		} // end of inputs
		
		// M개의 치킨집 조합 
		isSelected = new boolean[chickens.size()];
		comb(0, 0);
		
		System.out.println(minDist);
	}
	
	public static void comb(int cnt, int idx) {
		if (cnt == M) {
			// 각 집의 치킨 거리 합 구하기 
			int sum = 0;
			for (Point p : houses) {
				sum += calDist(p);
			}
			minDist = Math.min(sum, minDist);
			return;
		}
		if (idx == chickens.size()) return;
		
		for (int i = idx; i < chickens.size(); i++) {
			isSelected[i] = true;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
	
	public static int calDist(Point p) {
		// 맨해튼거리 최솟값 찾기 
		int dist = 1234567890;
		for (int i = 0; i < chickens.size(); i++) {
			if (!isSelected[i]) continue;
			Point q = chickens.get(i);
			int d = Math.abs(p.r - q.r) + Math.abs(p.c - q.c);
			dist = Math.min(dist, d);
		}
		return dist;
	}
	
	public static class Point{
		int r, c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
}

/**
 * 도시 각 칸은 빈칸, 치킨집, 집
 * 치킨거리: 집과 가장 가까운 치킨집 사이의 거리
 * 도시의 치킨 거리: 모든 집의 치킨거리의 합
 * 최대 M개를 고르고 나머지 폐업 (폐업 안시킬 치킨집이 최대 M개) -> 도시의 치킨거리 최솟값
 * 
 * 치킨집이 M개보다 적으면 치킨거리는 무조건 M개일때보다 크거나 같음
 * => M개의 치킨집을 선택하는 조합을 뽑고 치킨거리 최솟값을 구한다 (백트래킹)
 */