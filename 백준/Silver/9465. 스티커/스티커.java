import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[][] stickers = new int[2][n];
			
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < n; c++) {
					stickers[r][c] = sc.nextInt();
				}
			}
			
			System.out.println(solve(n, stickers));
		}
	}
	
	public static int solve(int n, int[][] stickers) {
		int[][] dp = new int[2][n+1];
		
		dp[0][1] = stickers[0][0];
		dp[1][1] = stickers[1][0];
		
		for (int i = 2; i < n+1; i++) {
			dp[0][i] = stickers[0][i-1] + Math.max(dp[1][i-1], dp[1][i-2]);
			dp[1][i] = stickers[1][i-1] + Math.max(dp[0][i-1], dp[0][i-2]);
		}
		
//		System.out.println(Arrays.deepToString(dp)); // 디버깅 
		
		return Math.max(dp[0][n], dp[1][n]);
	}
}
