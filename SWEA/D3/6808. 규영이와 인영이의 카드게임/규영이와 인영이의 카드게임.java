
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution
{
	public static int[] gyu = new int[9];
	public static int[] in = new int[9];
	public static boolean[] visited;
	public static int[] result; // 승, 패 경우의 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = new int[2]; 
			visited = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int n = Integer.parseInt(st.nextToken());
				gyu[i] = n;
				visited[n] = true;
			}
			
			perm(0);
			sb.append("#").append(t).append(" ").append(result[0]).append(" ").append(result[1]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void perm(int idx) {
		if (idx == 9) {
			// 승자 구하기
			int gCnt = 0, iCnt = 0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > in[i]) {
					gCnt += gyu[i] + in[i];
				}
				else if (gyu[i] < in[i]) {
					iCnt += gyu[i] + in[i];
				}
			}
			if (gCnt > iCnt) result[0]++;
			else if (gCnt < iCnt) result[1]++;
				
			return;
		}
		for (int i = 1; i <= 18; i++) {
			if (!visited[i]) {
				visited[i] = true;
				in[idx] = i;
				perm(idx+1);
				visited[i] = false;
			}
		}
	}
}
