import java.io.*;
import java.util.*;
   
public class Solution
{
    static int N, maxH, cnt;
    static int[] arr;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N];
        	maxH = cnt = 0;
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        		if (arr[i] > maxH) maxH = arr[i];
        	}
        	
        	int odd = 0, even = 0;
        	for (int i = 0; i < N; i++) {
        		odd += (maxH - arr[i]) % 2;
        		even += (maxH - arr[i]) / 2;
        	}
        	
        	if (odd > even) {
        		cnt = odd * 2 - 1;
        	}
        	else {
        		while (Math.abs(even - odd) > 1) {
        			even -= 1;
        			odd += 2;
        		}
        		if (odd > even)
        			cnt = odd * 2 - 1;
        		else
        			cnt = even * 2;
        	}
        	
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}