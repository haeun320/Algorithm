

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        for (int i = 0; i < 10; i++) {
            String t = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < 8; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            
ex:          while(true) {
            	for (int d = 1; d < 6; d++) {
            		int n = deque.remove();
            		n -= d;
            		
            		if (n <= 0) {
            			n = 0;
            			deque.add(n);
            			break ex;
            		}
            		deque.add(n);
            	}
            }
            
            sb.append("#").append(t);
            while(!deque.isEmpty()) {
                sb.append(" ").append(deque.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}