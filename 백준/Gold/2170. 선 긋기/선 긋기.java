import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2]; // [ [선의 시작점, 끝점] ]
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0]) return a[1] - b[1];
			return a[0] - b[0];
		}); 
		
		int sum = arr[0][1] - arr[0][0];
		int[] line = arr[0].clone();
		for (int i = 1; i < N; i++) {
			if (arr[i][0] <= line[1]) {
				if (arr[i][1] <= line[1]) { // 선 안에 완전히 포함될 때
					continue;
				}
				else { // 일부만 겹칠 때
					sum += Math.abs(arr[i][1] - line[1]);
					line[1] = arr[i][1];
				}
			}
			else {
				line = arr[i].clone();
				sum += Math.abs(arr[i][1] - arr[i][0]);
			}
		}
		
		System.out.println(sum);
	}
}