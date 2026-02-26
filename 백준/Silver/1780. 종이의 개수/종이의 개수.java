import java.util.*;
import java.io.*;

class Main
{
	static int[] result;
	static int[][] map;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int k = 0, tmpN = N; // 지수 구하기 
		while (tmpN % 3 == 0) {
            tmpN /= 3;
            k++;
        }
		
		result = new int[3];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// recur 호출
		recur(k, 0, 0);
		for (int i = 0; i < 3; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	/**
	 * 
	 * @param k 3의 지수
	 * @param r 종이 시작점 row
	 * @param c 종이 시작점 col
	 */
	public static void recur(int k, int r, int c) {
		if (k == 0) {
			result[map[r][c]+1]++;
			return;
		}
		int N = (int) Math.pow(3, k);
		
		// 모두 같은 수로 채워져있는지 확인
		int a = map[r][c];
		boolean isSame = true;
		loop:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (a != map[r+i][c+j]) {
					isSame = false;
					break loop;
				}
			}
		}
		
		// 모두 같은 수로 채워져있으면 종이 1장으로 처리 후 종료
		if (isSame) {
			result[a+1]++;
			return;
		}
		
		// 다른 수가 있다면 9장으로 쪼개기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				recur(k-1, r + (int)Math.pow(3, k-1) * i, c + (int)Math.pow(3, k-1) * j);
			}
		}
	}
}
