import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] memo = new int[1001];
		memo[1] = 1;
		memo[2] = 3;
		
		int result = dp(memo, n);
		System.out.println(result);
	}
	
	public static int dp(int[] memo, int d) {
		if (memo[d] != 0)
			return memo[d];
		
		memo[d] = (dp(memo, d-1) + 2 * dp(memo, d-2)) % 10007;
		return memo[d];
	}
}
