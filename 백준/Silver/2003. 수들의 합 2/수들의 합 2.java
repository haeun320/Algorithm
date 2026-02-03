import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefix = new int[N+1];
		for (int i = 1; i <= N; i++) {
			prefix[i] = prefix[i-1] + arr[i-1];
		}
		
		int cnt = 0;
		int p1 = 0, p2 = 0;
		while (p2 <= N){
			int cal = prefix[p2] - prefix[p1]; 
//			System.out.println("p2="+p2+", p1="+p1+", cal="+cal);
			if (cal == M) {
				cnt++;
				p1++;
			}
			else if (cal > M) {
				p1++;
			}
			else {
				p2++;
			}
		}
		
		System.out.println(cnt);
	}
}
