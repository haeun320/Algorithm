import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indeg = new int[N+1];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			indeg[b]++;
			graph.get(a).add(b);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				q.add(i);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			int curr = q.poll();
			result.add(curr);
			
			for (int next: graph.get(curr)) {
				indeg[next]--;
				if (indeg[next] == 0) {
					q.add(next);
				}
			}
		}
		
		for (int n: result) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
}
