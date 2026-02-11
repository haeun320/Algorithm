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
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int m = N / 2;
			int result = 0;
			for (int i = 0; i <= m; i++) {
				for (int j = m-i; j < m+i+1; j++) {
					result += map[i][j];
				}
			}
			for (int i = 0, r = N-1; i < m; i++, r--) {
				for (int j = m-i; j < m+i+1; j++) {
					result += map[r][j];

				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
} 