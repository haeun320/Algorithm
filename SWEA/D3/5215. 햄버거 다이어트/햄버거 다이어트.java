import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int tc = 1; tc <= T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int L = Integer.parseInt(st.nextToken());
    		int[][] dp = new int[N+1][L+1];
    		
    		for (int i = 1; i <= N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int t = Integer.parseInt(st.nextToken());
    			int k = Integer.parseInt(st.nextToken());
    			
    			for (int j = 1; j <= L; j++) {
    				dp[i][j] = dp[i-1][j];
    				
    				if (j >= k)
    					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k]+t);
    			}
    		}
    		int max = 0;
    		for (int x: dp[N]) {
    			if(x > max) max = x;
    		}
    		sb.append("#").append(tc).append(" ").append(max).append("\n");
    	}
    	System.out.println(sb);
    }
}