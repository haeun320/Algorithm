import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int idx = 0;
			int result = 0;
			// idx가 끝까지 갈때까지
			while (idx < N-1) {
				int cntu = 0, cntd = 0;
				// 올라가는 구간 찾기
				while (idx + 1 < N && arr[idx]< arr[idx+1]) {
					idx++;
					cntu++;
				}
				// 올라가는 구간 찾기 성공 후 루프 끝남 -> 내려가는 구간 찾기
				if (cntu > 0) {
					while (idx + 1 < N && arr[idx]> arr[idx+1]) {
						idx++;
						cntd++;
					}
					// 올라가는 구간, 내려가는 구간 다 찾으면 result += cnta * cntb 
					if (cntd > 0) {
						result += cntu * cntd;
					}
				}
				// 올라가는 구간이 없으면 다음 인덱스부터 확인
				else {
					idx++;
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
} 