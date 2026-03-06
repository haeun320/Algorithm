import java.util.*;
import java.io.*;

public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>(); // min-heap
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < N; j++) {
			int n = Integer.parseInt(st.nextToken());
			pq.add(n);
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (pq.peek() < n) { // 큐의 최솟값보다 새로 들어온 숫자가 크면 갱신
		            pq.poll();
		            pq.add(n);
		        }
			}
		} 
		
		// 크기가 N인 min-heap의 peek == N번째 큰 수
		System.out.println(pq.peek());
	}
}
