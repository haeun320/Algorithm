import java.io.*;
import java.util.*;
   
public class Solution
{
	static int[] price;
	static int[] plan;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			plan = new int[12];
			
			// 입력 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			// 연산
			result = price[3]; // 연간권 비용으로 초기화
			dfs(0, 0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int month, int sum) {
		if (sum >= result) return;
		if (month >= 12) {
			result = Math.min(result, sum);
			return;
		}
		
		// 현재 달 1일권 선택
		dfs(month+1, sum + plan[month] * price[0]);
		// 현재 달 한달권 선택
		dfs(month+1, sum + price[1]);
		// 현재 달 3달권 선택
		dfs(month+3, sum + price[2]);
	}
} 