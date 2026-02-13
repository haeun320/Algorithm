import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			int cnt = 0;
			while (N != 2) {
				long r = (long) Math.ceil(Math.sqrt(N));
				cnt += Math.pow(r, 2) - N + 1;
				N = r;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
} 