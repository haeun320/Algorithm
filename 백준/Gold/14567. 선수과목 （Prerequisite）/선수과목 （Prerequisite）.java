import java.io.*;
import java.util.*;

public class Main{
	static int N, M;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] result = new int[N+1];
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		int[] indeg = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indeg[b]++;
		} // end of inputs
		
		Queue<int[]> q = new ArrayDeque<>(); // {과목 번호, 날짜 수}
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) q.add(new int[] {i,1});
		}
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int n = curr[0];
			int d = curr[1];
			
			result[n] = d;
			
			for (int next: graph.get(n)) {
				indeg[next]--;
				if (indeg[next] == 0) {
					q.add(new int[] {next, d+1});
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}