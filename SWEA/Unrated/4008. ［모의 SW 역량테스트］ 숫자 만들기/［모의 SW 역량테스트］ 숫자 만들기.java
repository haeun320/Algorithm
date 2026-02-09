import java.io.*;
import java.util.*;
   
public class Solution
{
	static int N, min, max;
	static int[] nums, ops;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			ops = new int[4];
			
			st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
            	ops[i] = Integer.parseInt(st.nextToken());
            }
			
			nums = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			perm(1, nums[0]);
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void perm(int idx, int cal) {
		if (idx == N) {
			if (min > cal) min = cal;
			if (max < cal) max = cal;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (ops[i] <= 0) continue; // 남은 연산자가 없으면 스킵
			ops[i]--;
			int nextCal = calculate(cal, nums[idx], i);
			perm(idx+1, nextCal);
			ops[i]++;
		}
	}
	
	public static int calculate(int a, int b, int op) {
		switch (op) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		case 3:
			return a / b;
		}
		return -1;
	}
}