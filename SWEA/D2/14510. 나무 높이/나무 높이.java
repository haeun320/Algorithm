import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			int maxH = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, tree[i]);
			}
			
			int odd = 0; // 홀수
			int even = 0; // 짝수
			for (int i = 0; i < N; i++) {
				int n = maxH - tree[i];
				odd += n % 2;
				even += n / 2;
			}
			
			int result = 0;
			while (even > odd + 1) {
				even -= 1;
				odd += 2;
			}
			if (odd > even) {
				result = odd * 2 - 1;
			}
			else {
				result = even * 2;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
} 