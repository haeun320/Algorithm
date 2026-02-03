
import java.io.*;
import java.util.*;

public class Solution
{
	public static int[][] map = new int[16][16];
	public static int[] start = new int[2]; // 시작 좌표
	public static int[] end = new int[2]; // 도착 좌표
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for (int t = 1; t <= 10; t++) {
    		int tc = Integer.parseInt(br.readLine());
    		
    		for (int i = 0; i < 16; i++) {
    			String str = br.readLine();
    			for (int j = 0; j < 16; j++) {
    				int c = str.charAt(j) - '0';
    				map[i][j] = c;
    				if (c == 2) {
    					start[0] = i; start[1] = j;
    				}
    				if (c == 3) {
    					end[0] = i; end[0] = j;
    				}
    			}
    		}
    		
    		int result = bfs() ? 1 : 0;
    		sb.append("#").append(tc).append(" ").append(result).append("\n");
    	}
    	System.out.println(sb);
    }
    
    public static boolean bfs() {
    	boolean[][] visited = new boolean[16][16];
    	Queue<int[]> q = new ArrayDeque<>();
    	
    	visited[start[0]][start[1]] = true;
    	q.add(new int[]{start[0], start[1]});
    	
    	while (!q.isEmpty()) {
    		int[] n = q.poll();
    		if (map[n[0]][n[1]] == 3)
    			return true;
    		
    		for (int i = 0; i < 4; i++) {
    			int r = n[0] + dr[i];
    			int c = n[1] + dc[i];
    			
    			if (r < 0 || r >= 16 || c < 0 || c >= 16)
    				continue;
    			
    			if (map[r][c] == 1 || visited[r][c]) // 벽이거나 방문한 노드면 패스
    				continue;
    			
    			q.add(new int[] {r, c});
    			visited[r][c] = true;
    		}
    	}
    	
    	return false;
    }
}