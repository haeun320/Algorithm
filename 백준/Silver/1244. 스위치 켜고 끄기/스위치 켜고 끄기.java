import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringBuilder sb = new StringBuilder(); // 출력 저장 
		
		int n = Integer.parseInt(br.readLine()); // <= 100
		int[] led = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			led[i] = Integer.parseInt(st.nextToken()); // led 초기화 
		}
		
		int studentNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentNum; i++) { // 학생 수만큼 반복
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int idx = Integer.parseInt(st.nextToken()); // 번호
			
			switch(gender) {
			case 1: // 남학생
				for (int j = idx; j <= n; j += idx) {
						led[j] ^= 1;
				}
				break;
			case 2: // 여학생 
				led[idx] ^= 1;
				for (int j = 1; ; j++) {
					if (idx+j <= n && idx-j > 0) { // 범위 내에서 
						if (led[idx+j] == led[idx-j]) { // 대칭 같을때까지 반복
							led[idx+j] ^= 1; // led 상태 반전
							led[idx-j] ^= 1; // led 상태 반전
						}
						else break;
					} else break;
				}
				break;
			}
		}
		
		// 20개씩 끊어서 출력 
		int k = (int)(n/20)+1;
		for (int i = 0; i < k; i++) {
			for (int j = 1 + 20 * i, p = 0; p < 20; p++, j++) {
				if (j <= n) sb.append(led[j]).append(" ");
				else break;
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
