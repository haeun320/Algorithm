	import java.util.*;
	import java.io.*;
	
	public class Main {
		static int N, M; // 도시 개수, 버스 개수 
		static int[][] d;
		static int MAX = 987654321; // int overflow 방지를 위한 최대값 초기화 
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			d = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(d[i], MAX);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				// 시작 도시-도착 도시 노선이 하나가 아닐 수 있기 때문에, 최솟값으로 저장 
				d[a][b] = Math.min(d[a][b], c);
			}
			
			// 자기 자신으로 가는 비용 0으로 초기화
			for (int i = 1; i <= N; i++) d[i][i] = 0;
			
			// 3중 for문을 사용한 플로이드 알고리즘 구현
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						// i->j 바로 가기 vs. i->k->j 거쳐 가기
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(d[i][j] == MAX ? 0 : d[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}