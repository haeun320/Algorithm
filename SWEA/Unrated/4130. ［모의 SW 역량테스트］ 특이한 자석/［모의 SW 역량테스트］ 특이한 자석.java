import java.io.*;
import java.util.*;
  
public class Solution
{
	// 각 자석에서 0번 인덱스: 점수 확인 위치, 2번: 오른쪽, 6번: 왼쪽
    private static int[][] arr; // 자석별 자성 정보 저장
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	arr = new int[4][8];
        	int K = Integer.parseInt(br.readLine());
        	for (int i = 0; i < 4; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		for (int j = 0; j < 8; j++) {
        			// N극: 0, S극: 1
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for (int i = 0; i < K; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		// 회전 자석 번호(1based), 회전 방향 입력 
        		int n = Integer.parseInt(st.nextToken());
        		boolean cw = Integer.parseInt(st.nextToken()) > 0;
        		// 회전
        		turn(n-1, 3, cw);
        	}
        	
        	// 점수 계산
        	int point = 0;
            for (int i = 0; i < 4; i++) {
            	point += arr[i][0] * (int)Math.pow(2, i);
            }
            sb.append("#").append(t).append(" ").append(point).append("\n");
        }
        System.out.println(sb);
    }
    
    // param 현재 자석의 번호(0~3), 진행 방향(1,2,3), 회전 방향(true 시계방향, false 반시계방향)
    public static void turn(int n, int direction, boolean cw) {
    	// 진행 방향으로 옆의 자석 확인
    	// 극이 다르면 옆의 자석도 회전할 것 (재귀)
    	if (direction == 1) { // 왼쪽
    		if (n-1 >= 0 && arr[n][6] != arr[n-1][2])
    			turn(n-1, direction, !cw);
    	}
    	else if (direction == 2) { // 오른쪽
    		if (n+1 < 4 && arr[n][2] != arr[n+1][6])
    			turn(n+1, direction, !cw);
    	}
    	else { // 양쪽
    		if (n-1 >= 0 && arr[n][6] != arr[n-1][2])
    			turn(n-1, 1, !cw);
    		if (n+1 < 4 && arr[n][2] != arr[n+1][6])
    			turn(n+1, 2, !cw);
    	}
    	
    	// 현재 자석 회전
    	if (cw) { // 시계방향
    		int t = arr[n][7];
    		for (int i = 7; i > 0; i--) {
    			arr[n][i] = arr[n][i-1];
    		}
    		arr[n][0] = t;
    	}
    	else { // 반시계방향
    		int t = arr[n][0];
    		for (int i = 0; i < 7; i++) {
    			arr[n][i] = arr[n][i+1];
    		}
    		arr[n][7] = t;
    	}
    }
}