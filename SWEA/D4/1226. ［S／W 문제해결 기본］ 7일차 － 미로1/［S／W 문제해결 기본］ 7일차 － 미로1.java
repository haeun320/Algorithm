
import java.io.*;
import java.util.*;

public class Solution
{
	public static int[][] map = new int[16][16];
	public static int[] parent = new int[256];
	public static int[] dr = {0, 1};
	public static int[] dc = {1, 0};
	
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for (int t = 1; t <= 10; t++) {
    		int tc = Integer.parseInt(br.readLine());
    		for (int i = 0; i < 256; i++) parent[i] = i; // 자기 자신을 루트로 갖도록 초기화
    		
    		int start = -1, end = -1;
    		
    		for (int i = 0; i < 16; i++) {
    			String str = br.readLine();
    			for (int j = 0; j < 16; j++) {
    				int c = str.charAt(j) - '0';
    				map[i][j] = c;
    				
    				int idx = i * 16 + j;
    				if (c == 2) start = idx;
    				if (c == 3) end = idx;
    			}
    		}
    		
    		// Union
    		for (int i = 0; i < 16 ; i++) {
    			for (int j = 0; j < 16; j++) {
    				if (map[i][j] == 1)
    					continue;
    				
    				for (int d = 0; d < 2; d++) {
    					int r = i + dr[d];
    					int c = j + dc[d];
    					
    					if (r < 16 && c < 16 && map[r][c] != 1) {
    						union(i*16+j, r*16+c);
    					}
    				}
    			}
    		}
    		
    		// 시작점과 도착점이 같은 집합에 있는지 확인
    		int result = (find(start) == find(end)) ? 1 : 0;
    		sb.append("#").append(tc).append(" ").append(result).append("\n");
    	}
    	System.out.println(sb);
    }
    
    public static void union(int i, int j) {
    	int rootI = find(i);
    	int rootJ = find(j);
    	if (rootI != rootJ) {
    		parent[rootI] = rootJ;
    	}
    }
    
    public static int find(int i) {
    	if (parent[i] == i) return i;
    	return parent[i] = find(parent[i]);
    }
    
}