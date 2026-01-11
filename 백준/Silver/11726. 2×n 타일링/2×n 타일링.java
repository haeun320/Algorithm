import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int[] memo = new int[1001];
		memo[1] = 1;
		memo[2] = 2;
		
		int result = dp(memo, n);
		System.out.println(result);
	}
	
	public static int dp(int[] memo, int d) {
		if (memo[d] != 0)
			return memo[d];
		
		int m = 10007;
		memo[d] = (dp(memo, d-1) + dp(memo, d-2)) % m;
		return memo[d];
	}
}
