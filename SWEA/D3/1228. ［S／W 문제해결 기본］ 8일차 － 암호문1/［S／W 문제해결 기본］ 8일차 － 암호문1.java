

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for (int t = 1; t <= 10; t++) {
    		int N = Integer.parseInt(br.readLine());
    		LinkedList<Integer> list = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < N; i++) {
    			list.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		int cnt = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		
    		for (int i = 0; i < cnt; i++) {
    			String ord = st.nextToken();
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			for (int j = 0; j < y; j++) {
    				int s = Integer.parseInt(st.nextToken());
    				list.add(x++, s);
    			}
    		}
    		
        	System.out.print("#"+t);
        	for (int i = 0; i < 10; i++) {
        		System.out.print(" "+list.get(i));
        	}
        	System.out.println();
    	}
    }
}