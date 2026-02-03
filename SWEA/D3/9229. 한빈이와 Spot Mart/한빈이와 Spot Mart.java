
import java.io.*;
import java.util.*;

public class Solution
{
	// N개의 과자 봉지 중에서 정확히 2개 골랐을 때 가능한 최대의 무게 합
	// 투포인터? 
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int p1 = 0, p2 = n-1;
			int result = -1;
			while (p1 < p2) {
				int sum = arr[p1] + arr[p2]; 
				if (sum <= m) {
					result = result < sum ? sum : result;
					p1++;
				}
				else {
					p2--;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
