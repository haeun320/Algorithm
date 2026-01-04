import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();
		
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		int result = 0;
		
		while (K > 0) {
			int p = 0;
			while (p < N && coins[p] <= K) p++;
			if (p > 0) p--;
			
			K -= coins[p];
			result++;
		}
		
		System.out.println(result);
	}
}
