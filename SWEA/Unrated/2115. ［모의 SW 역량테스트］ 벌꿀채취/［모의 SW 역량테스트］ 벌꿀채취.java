import java.util.*;
import java.io.*;

public class Solution {
	private static int[][] arr; // 꿀의 양 
	private static int[][] map; // (r,c)에서 가능한 최대 수익 
	private static int N, M, C;
	private static int tProfit; // 구간 내 최대 수익 
	private static int mProfit; // 두 일꾼 최대 수익 합 
	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int tc = 1; tc <= T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		C = Integer.parseInt(st.nextToken());
    		
    		arr = new int[N][N];
    		map = new int[N][N-M+1];
    		mProfit = 0;
    		
    		for (int i = 0; i < N; i++) {
    			st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < N; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		// 최대수익 맵
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N-M+1; j++) {
    				// arr[i][j]~arr[i][j+M] 안에서 가능한 최대 수익을 map[i][j]에 저장
    				// 조합: 1개부터 최대 M개까지 선택해서, 합이 C이하이고 제곱의 합이 최대인 경우 찾기
    				tProfit = 0;
    				getMaxProfit(i, j, 0, 0, 0); // tProfit
    				map[i][j] = tProfit;
    				
    			}
    		}
    		
    		cal(0, 0, 0, 0);
    		
    		sb.append("#").append(tc).append(" ").append(mProfit).append("\n");
    	}
    	System.out.println(sb);
    }
    
    public static void getMaxProfit(int r, int c, int idx, int sum, int profit) {
    	if (idx == M) { // 기저조건 
    		tProfit = Math.max(tProfit, profit);
    		return;
    	}
    	
    	int curr = arr[r][c+idx]; // 현재 벌통의 꿀 양 
    	
    	// 현재 벌통을 선택하는 경우
    	if (sum + curr <= C) {
    		getMaxProfit(r, c, idx+1, sum+curr, profit+(int)Math.pow(curr, 2));
    	}
    	
    	// 현재 벌통을 선택하지 않는 경우 
    	getMaxProfit(r, c, idx+1, sum, profit);
    }
    
    public static void cal(int r, int c, int sum, int cnt) {
    	if (cnt == 2) {
    		mProfit = Math.max(mProfit, sum);
    		return;
    	}

    	// 범위가 겹치면 안됨 -> 같은 row면 M개 건너뛰어야 함
    	for (int i = r; i < N; i++) {
    		for (int j = (r == i ? c : 0); j < N-M+1; j++) {
    			cal(i, j+M, sum+map[i][j], cnt+1);
    		}
    	}
    }
}