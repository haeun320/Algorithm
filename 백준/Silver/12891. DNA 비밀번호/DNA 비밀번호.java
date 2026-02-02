import java.util.*;
import java.io.*;

public class Main {
	public static int[] min = new int[4]; // A, C, G, T 최소 개수 
	public static int[] cnt = new int[4]; // 윈도우 내 A, C, G, T 개수


	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;

		// 초기 부분 문자열 만들기
		for (int i = 0; i < p; i++) {
			int idx = getIdx(str.charAt(i));
			cnt[idx]++;
		}
		
		if (isPW()) result++;
		
		for (int i = p; i < s; i++) {
			// 다음 부분 문자열 만들기
			cnt[getIdx(str.charAt(i-p))]--;
			cnt[getIdx(str.charAt(i))]++;
			
			// 현재 부분문자열이 문자 최소 개수를 만족하는지 확인
			if (isPW()) result++;
		}
		
		System.out.println(result);
	}
	
	public static int getIdx(char c) {
		int idx = 0;
		switch (c) {
		case 'A':
			idx = 0;
			break;
		case 'C':
			idx = 1;
			break;
		case 'G':
			idx = 2;
			break;
		case 'T':
			idx = 3;
			break;
		}
		return idx;
	}
	
	public static boolean isPW() {
		for (int i = 0; i < 4; i++) {
			if (cnt[i] < min[i]) return false;
		}
		return true;
	}
}
