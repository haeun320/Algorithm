import java.io.*;
import java.util.*;
   
public class Solution
{
	private static int[][] map = new int[4001][4001];
	private static int N;
	private static List<Atom> atoms;
	private static int[] dx = {0, 0, -1, 1}; // 상하좌우
	private static int[] dy = {1, -1, 0, 0};
	private static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			atoms = new ArrayList<Atom>();
			result = 0;
			
			for (int i = 0; i < N; i++) {
			    st = new StringTokenizer(br.readLine());
			    int x = (Integer.parseInt(st.nextToken()) + 1000) * 2; // -1000 -> 0, 1000 -> 4000
			    int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
			    int dir = Integer.parseInt(st.nextToken());
			    int k = Integer.parseInt(st.nextToken());
			    atoms.add(new Atom(x, y, dir, k));
			}
			
			// 루프 돌기 (최대 4000번)
			while (!atoms.isEmpty()) {
				// 이동 방향에 따라 원자 위치를 1씩 이동시키기 (0.5초 경과)
				for (int i = atoms.size() - 1; i >= 0; i--) {
				    Atom a = atoms.get(i);
				    int nx = a.x + dx[a.dir];
				    int ny = a.y + dy[a.dir];
				    
				    if (nx < 0 || nx > 4000 || ny < 0 || ny > 4000) {
				        atoms.remove(i);
				        continue;
				    }
				    
				    a.x = nx;
				    a.y = ny;
				    // 이동 위치를 맵에 기록하기 (에너지로 기록)
				    map[a.x][a.y] += a.k;
				}
				
				List<Atom> tmp = new ArrayList<>();
				// 충돌 확인
				for (int i = atoms.size() - 1; i >= 0; i--) {
					Atom a = atoms.get(i);
					// 맵에 저장된 자신의 위치의 에너지가 자신이 가진 에너지보다 크다 -> 누군가와 부딪혔다
					// 충돌한 원자를 기록
					if (map[a.x][a.y] > a.k) {
						result += a.k;
						tmp.add(a);
					}
				}
				
				// 맵 초기화
				for (Atom a : atoms) {
					map[a.x][a.y] = 0;
				}
				
				// 충돌 원자 삭제
				for (Atom a : tmp) {
					atoms.remove(a);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static class Atom {
		int x;
		int y;
		int dir;
		int k;
		
		public Atom(int x, int y, int dir, int k) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
} 