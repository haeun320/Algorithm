import java.io.*;
import java.util.*;
  
public class Solution
{
	static boolean[][] miss; // 안맞는 궁합 저장 
	static int N, M, result;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료 번호 1번부터
			M = Integer.parseInt(st.nextToken()); // 궁합 안맞는 쌍의 수
			
			miss = new boolean[N+1][N+1];
			isSelected = new boolean[N+1];
			result = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				miss[a][b] = true;
				miss[b][a] = true;
			}
			comb(1, 0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	// 가능한 조합의 수 세기
	// idx: 현재 재료 번호, cnt: 선택한 개수
	public static void comb(int idx, int cnt) {
		if (idx == N+1) {
			result++;
			return;
		}
		
		// 현재 재료를 뽑는 경우 -> 안맞는 궁합이 없어야함
		boolean isPossible = true; 
		for (int i = 1; i <= N; i++) {
			if (isSelected[i] && miss[idx][i])
				isPossible = false;
		}
		if (isPossible) {
			isSelected[idx] = true;
			comb(idx+1, cnt+1);
		}
		
		// 현재 재료를 뽑지 않는 경우
		isSelected[idx] = false;
		comb(idx+1, cnt);
	}
}