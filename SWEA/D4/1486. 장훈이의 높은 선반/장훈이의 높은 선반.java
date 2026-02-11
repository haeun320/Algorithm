import java.io.*;
import java.util.*;

public class Solution
{
	static int N, B, result;
	static int[] h;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 점원 수
			B = Integer.parseInt(st.nextToken()); // 필요한 최소 높이
			st = new StringTokenizer(br.readLine(), " ");
			h = new int[N];
			for (int i = 0; i < N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			result = Integer.MAX_VALUE;
			solve(0, 0);
			
			sb.append("#").append(tc).append(" ").append(result-B).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void solve(int idx, int sum) {
		if (idx == N) {
			if (sum >= B) {
				result = Math.min(sum, result);
			}
			return;
		}
		
		// 현재 직원 선택
		solve(idx+1, sum + h[idx]);
		// 현재 직원 노선택
		solve(idx+1, sum);
	}
} 