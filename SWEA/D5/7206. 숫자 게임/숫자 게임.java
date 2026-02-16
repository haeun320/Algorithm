import java.io.*;
import java.util.*;

public class Solution {
	static int[] memo;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            //N = Integer.parseInt(br.readLine());
        	String N = br.readLine();
        	memo = new int[100000];
        	int result = dfs(N);
            
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int dfs(String n) {
    	if (n.length() == 1) {
    		return 0;
    	}
    	
    	int num = Integer.parseInt(n);
    	if (memo[num] != 0) {
    		return memo[num];
    	}
    	
    	// 터치 지점 조합 구하기 
    	comb(n.length(), 1, new boolean[n.length()], n);
    	
    	return memo[num];
    	
    }
    
    /**
     * 
     * @param len 숫자 자릿수 (= 문자열 길이 = 터치 지점 최댓값+1)  
     * @param idx 현재 확인하는 지점 인덱스 
     * @param isSelected 터치 지점 선택 여부 
     * @param n 숫자 문자열 
     */
    public static void comb(int len, int idx, boolean[] isSelected, String n) {
    	if (idx == len) {
    		// 터치 지점을 하나도 선택하지 않은 조합은 폐기 
    		boolean anyCut = false;
            for (int i = 1; i < len; i++) {
                if (isSelected[i]) { 
                	anyCut = true;
                	break;
            	}
            }
            if (!anyCut) return;
            
    		int start = 0, nextVal = 1;
    		for (int i = 1; i < len; i++) {
    			if (isSelected[i]) {
    				nextVal *= Integer.parseInt(n.substring(start, i));
    				start = i;
    			}
    		}
    		nextVal *= Integer.parseInt(n.substring(start, len));
    		
    		// 현재 터치 지점 조합으로 나온 수(nextVal)의 최대 턴 수 구하기 ==> dfs 호출
    		int num = Integer.parseInt(n);
    		memo[num] = Math.max(dfs(Integer.toString(nextVal)) + 1, memo[num]);
    		return;
    	}
    	 
    	isSelected[idx] = true; // 현재 지점 터치 선택
    	comb(len, idx+1, isSelected, n);
    	isSelected[idx] = false; // 현재 지점 터치 선택 안함 
    	comb(len, idx+1, isSelected, n);
    }
}