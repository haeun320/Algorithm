
import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for (int t = 1; t <= 10; t++) {
    		int N = Integer.parseInt(br.readLine());
    		List<Integer> list = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		for (int i = 0; i < N; i++) {
    			list.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		int cnt = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine(), " ");
    		 
            for (int i = 0; i < cnt; i++) {
                String ord = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for (int j = 0; j < y; j++) {
                    int s = Integer.parseInt(st.nextToken());
                    list.add(x++, s);
                }
            }
             
    		sb.append("#").append(t);
        	for (int i = 0; i < 10; i++) {
        		sb.append(" ").append(list.get(i));
        	}
        	sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
}