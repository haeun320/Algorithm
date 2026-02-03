import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		TreeSet<Problem> set = new TreeSet<>((p1, p2)-> {
			if (p1.level == p2.level) return p1.num - p2.num; // 난이도가 같으면 번호순 정렬
			return p1.level - p2.level; // 1순위 난이도순 정렬
		});
		Map<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			set.add(new Problem(p, l));
			map.put(p, l);
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String or = st.nextToken();
			
			switch (or) {
			case "recommend":
				int x = Integer.parseInt(st.nextToken()); // 가장 어려운 문제
				if (x == 1) {
					sb.append(set.last().num).append("\n");
				}
				else if (x == -1) { // 가장 쉬운 문제
					sb.append(set.first().num).append("\n");
				}
				break;
			case "add":
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				set.add(new Problem(p, l));
				map.put(p, l);
				break;
			case "solved":
				int num = Integer.parseInt(st.nextToken());
				int level = map.get(num);
				set.remove(new Problem(num, level));
				map.remove(num);
				break;
			}
		}
		System.out.println(sb);
	}
	
	public static class Problem {
		int num;
		int level;
		
		Problem(int n, int l){
			num = n;
			level = l;
		}
	}
}
