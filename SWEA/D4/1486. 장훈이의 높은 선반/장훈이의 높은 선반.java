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
			int totalH = 0;
			for (int i = 0; i < N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
				totalH += h[i];
			}
			
			boolean[] dp = new boolean[totalH+1];
			dp[0] = true;
			
			for (int height: h) {
				for (int i = totalH; i >= height; i--) { // 뒤에서부터 현재 직원의 키까지
					if (dp[i-height]) dp[i] = true;
				}
			}
			
			result = totalH;
			for (int i = B; i <= totalH; i++) {
				if (dp[i]) {
					result = i;
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result-B).append("\n");
		}
		System.out.println(sb);
	}
	
} 