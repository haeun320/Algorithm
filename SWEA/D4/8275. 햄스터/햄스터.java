import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
 
public class Solution
{
	public static int[] hm; // 현재 햄스터 배치
	public static int[][] arr; // 기록
	public static int[] result; // 최종 햄스터 배치
	public static int sum;
	public static int N, M, X;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	X = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	hm = new int[N+1];
        	arr = new int[M][3];
        	
        	for (int i = 0; i < M; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for (int j = 0; j < 3; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	sb.append("#").append(t);
        	sum = -1;
        	result = null;
        	bt(1, 0);
        	if (result == null) {
        		sb.append(" ").append("-1").append("\n");
        		continue;
        	}
        	for (int i = 1; i < N+1; i++) {
        		sb.append(" ").append(result[i]);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    
    public static void bt(int idx, int currentSum) {
        if (idx == N + 1) {
            if (isPossible()) {
                if (currentSum >= sum) {
                    sum = currentSum;
                    result = hm.clone();
                }
            }
            return;
        }

        for (int i = X; i >= 0; i--) {
            if (sum != -1 && currentSum + i + (N - idx) * X < sum) {
                break;
            }

            hm[idx] = i;
            bt(idx + 1, currentSum + i);
        }
    }
    
    public static boolean isPossible() {
    	for (int i = 0; i < M; i++) {
    		int l = arr[i][0];
    		int r = arr[i][1];
    		int s = arr[i][2];
    		
    		int sum = 0;
    		for (int j = l; j <= r; j++) {
    			sum += hm[j];
    		}
    		
    		if (sum != s) return false;
    	}
    	return true;
    }
}