import java.io.*;
import java.util.*;
  
public class Solution
{
    public static char[][] map = new char[100][100];
    public static int start;
    public static int[] end;
    public static int[] dr = {0, 0, -1};
    public static int[] dc = {-1, 1, 0};
      
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
          
        for (int t = 0; t < 10; t++) {
            String tc = br.readLine();
              
            for (int i = 0; i < 100; i++) {
            	String s = br.readLine();
                for (int j = 0, index = 0; j < 100; j++, index+=2) {
                    map[i][j] = s.charAt(index);
                }
            }
            for (int i = 0; i < 100; i++) {
            	if (map[99][i] == '2') {
            		end = new int[] {99, i};
            		break;
            	}
            }
            
            // 도착점에 대응되는 출발점 찾기
            dfs(end[0], end[1]);
            sb.append("#").append(tc).append(" ").append(start).append("\n");
        }
        System.out.println(sb);
    }
      
    public static void dfs(int r, int c) {
        if (r == 0) {
            start = c;
            return;
        }
        map[r][c] = '0';
        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
              
            if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100)
                continue;
              
            if (map[nr][nc] == '1') {
                dfs(nr, nc);
                break;
            }
        }
    }
}