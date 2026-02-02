
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
                
                switch (ord) {
				case "I":
					for (int j = 0; j < y; j++) {
						int s = Integer.parseInt(st.nextToken());
						list.add(x++, s);
					}
					break;
				case "D":
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
					
				default:
					break;
				}
            }
             
    		sb.append("#").append(t);
    		int count = 0;
    		for (Integer num : list) {
    		    if (count == 10) break;
    		    sb.append(" ").append(num);
    		    count++;
    		}
        	sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
}