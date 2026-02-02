
import java.io.*;
import java.util.*;

public class Solution
{
	public static int N;
	public static int M;
	public static int[][] map;
	public static int[][] prefix;
	
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			prefix = new int[N + 1][N + 1]; // 1-based

			for (int i = 1; i <= N; i++) {
			    for (int j = 1; j <= N; j++) {
			        // (i, j)까지의 누적합 = 위쪽 + 왼쪽 - 대각선위 + 현재값
			        prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + map[i - 1][j - 1];
			    }
			}
			
			int result = 0;
			for (int r = M; r <= N; r++) {
				for (int c = M; c <= N; c++) {
					int s =  prefix[r][c] - prefix[r-M][c] - prefix[r][c-M] + prefix[r-M][c-M];
					result = s > result ? s : result;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
    }
}