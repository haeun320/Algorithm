import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] arr;
	static boolean[] picked;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// arr에서 수 6개를 뽑는 조합을 사전순으로 출력  
			picked = new boolean[k];
			pick(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
		public static void pick(int cnt, int idx) {
		if (cnt == 6) {
			for (int i = 0; i < k; i++) {
				if (picked[i])
					sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if (idx == k) return;
		
		for (int i = idx; i < k; i++) {
			picked[i] = true;
			pick(cnt+1, i+1);
			picked[i] = false;
		}
	}
}
