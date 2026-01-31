import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				if (stack.isEmpty() || stack.peek() != str.charAt(i)) {
					stack.add(str.charAt(i));
				}
				else {
					stack.pop();
				}
			}
			
			if (stack.isEmpty()) {
				result++;
			}
		}
		System.out.println(result);
	}
}
