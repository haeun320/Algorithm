import java.io.*;
import java.util.*;

public class Solution
{
	private static int N; // 식재료 수  4이상 16이하의 짝수
	private static int[][] S; // 조합 시너지
	private static int result; // 음식의 맛 최솟값
	
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			isSelected = new boolean[N];
			result = Integer.MAX_VALUE;
			comb(0, 0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void comb(int pickCnt, int idx) {
		if (pickCnt == N/2) {
			// isSelected에서 true인 집합과 false인 집합 각각 음식 맛 구하기
			int favT = 0, favF = 0;
			for (int i = 0; i < N; i++) {
				boolean b = isSelected[i];
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (isSelected[j] != b) continue;
					cnt += S[i][j];
				}
				if (b) favT += cnt;
				else favF += cnt;
			}
			
			int cal = Math.abs(favT - favF);
			if (result > cal) result = cal; 
			return;
		}
		if (idx == N) {
			return;
		}
		
		for (int i = idx; i < N; i++) {
			isSelected[i] = true;
			comb(pickCnt+1, i+1);
			isSelected[i] = false;
		}
	}
} 