import java.io.*;
import java.util.*;
   
public class Solution
{
     static int H, W, N;
     static char[][] map;
     static char[] order;
     static int posR, posC;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken()); 
            W = Integer.parseInt(st.nextToken()); 
            map = new char[H][];
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                map[i] = str.toCharArray();
            }
            N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            order = str.toCharArray();
            
            // 전차 현재 위치 저장
 loop:      for (int i = 0; i < H; i++) {
            	for (int j = 0; j < W; j++) {
            		if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
            			posR = i;
            			posC = j;
            			break loop;
            		}
            	}
            }
            
            // 사용자 입력 시뮬레이션
            for (int i = 0; i < N; i++) {
            	switch (order[i]) {
            	case 'U':
            		map[posR][posC] = '^';
            		go(posR-1, posC);
            		break;
            	case 'D':
            		map[posR][posC] = 'v';
            		go(posR+1, posC);
            		break;
            	case 'L':
            		map[posR][posC] = '<';
            		go(posR, posC-1);
            		break;
            	case 'R':
            		map[posR][posC] = '>';
            		go(posR, posC+1);
            		break;
            	case 'S':
            		shoot(posR, posC, getDirIndex(map[posR][posC]));
            		break;
            	}
            }
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
            	sb.append(String.valueOf(map[i])).append("\n");
            }
        }
        System.out.println(sb);
    }
    
    // param 목적지 r, c
    public static void go(int r, int c) {
    	if (r < 0 || r >= H || c < 0 || c >= W)
    		return;
    	if (map[r][c] == '.') {
    		char curr = map[posR][posC];
    		map[posR][posC] = '.';
    		posR = r;
    		posC = c;
    		map[posR][posC] = curr;
    	}
    }
    
    public static void shoot(int r, int c, int direction) {
    	if (r < 0 || r >= H || c < 0 || c >= W)
    		return;
    	if (map[r][c] == '#')
    		return;
    	if (map[r][c] == '*') {
    		map[r][c] = '.';
    		return;
    	}
    	
    	switch (direction) {
    	case 0: // 상
    		shoot(r-1, c, direction);
    		break;
    	case 1: // 하
    		shoot(r+1, c, direction);
    		break;
    	case 2: // 좌
    		shoot(r, c-1, direction);
    		break;
    	case 3: // 우
    		shoot(r, c+1, direction);
    		break;
    		
    	}
    }
    
    public static int getDirIndex(char c) {
        switch (c) {
	        case '^': return 0;
	        case 'v': return 1;
	        case '<': return 2;
	        case '>': return 3;
        };
		return -1;
    }
}