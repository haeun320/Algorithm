	import java.util.*;
	import java.io.*;
	
	public class Main {
		static int N, M; // 도시 개수, 버스 개수 
		static int[][] d;
		static int[][] nxt;
		static int MAX = 987654321; // int overflow 방지를 위한 최대값 초기화 
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			d = new int[N+1][N+1];
			nxt = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(d[i], MAX);
				Arrays.fill(nxt[i], MAX);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if (c < d[a][b]) {
			        d[a][b] = c;
			        nxt[a][b] = b;
			    }
			}
			
			// 자기 자신으로 가는 비용 0으로 초기화
			for (int i = 1; i <= N; i++) d[i][i] = 0;
			
			// 3중 for문을 사용한 플로이드 알고리즘 구현
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						// i->j 바로 가기 vs. i->k->j 거쳐 가기
						if(d[i][k] + d[k][j] < d[i][j]) {
							d[i][j] = d[i][k] + d[k][j];
							nxt[i][j] = nxt[i][k];
				        }
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(d[i][j] == MAX ? 0 : d[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			for (int i = 1; i <= N; i++) {
			    for (int j = 1; j <= N; j++) {
			        if (d[i][j] == 0 || d[i][j] == MAX) {
			            sb.append(0).append("\n");
			            continue;
			        }
			        
			        // 경로 복원하기
			        ArrayList<Integer> path = new ArrayList<>();
			        int start = i;
			        
			        while (start != j) {
			            path.add(start);
			            start = nxt[start][j];
			        }
			        path.add(j);
			        
			        sb.append(path.size()).append(" ");
			        for (int node : path) {
			            sb.append(node).append(" ");
			        }
			        sb.append("\n");
			    }
			}
			
			System.out.println(sb);
		}
	}