import java.util.Scanner;

public class Main {
	static int n, m;
	static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		int result = solve();
		System.out.println(result);
	}
	
	public static int solve() {
		int min = (int)1e9;
		
		for (int i = 0; i < n - 8 + 1; i++) {
			for (int j = 0; j < m - 8 + 1; j++) {
				int cnt = count(i, j);
				min = Math.min(min, cnt);
			}
		}
		
		return min;
	}
	
	public static int count(int row, int col) {
		int cntA = 0, cntB = 0;
		
		// 왼쪽 맨 위칸이 흰색인 경우 { W, B }
		char[] a = { 'W', 'B' };
		// 왼쪽 맨 아래칸이 검은색인 경우 { B, W }
		char[] b = { 'B', 'W' };
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int r = row + i;
				int c = col + j;
				
				if (board[r][c] != a[(i + j) % 2])
					cntA++;
				if (board[r][c] != b[(i + j) % 2])
					cntB++;
			}
		}
		
		return Math.min(cntA, cntB);
	}
}
