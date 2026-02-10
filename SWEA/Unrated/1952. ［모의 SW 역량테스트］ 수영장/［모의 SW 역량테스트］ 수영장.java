import java.io.*;
import java.util.*;
   
public class Solution
{
	static int[] price;
	static int[] plan;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			plan = new int[13];
			
			// 입력 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(tc).append(" ").append(dp()).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int dp() {
		int[] table = new int[13];
		table[1] = Math.min(price[0] * plan[1], price[1]);
		table[2] = Math.min(table[1] + price[0] * plan[2], table[1] + price[1]);
		
		for (int i = 3; i <= 12; i++) {
			table[i] = Math.min(table[i-1] + price[0] * plan[i], Math.min(table[i-1] + price[1], table[i-3] + price[2]));
		}
		
		return Math.min(table[12], price[3]);
	}
} 