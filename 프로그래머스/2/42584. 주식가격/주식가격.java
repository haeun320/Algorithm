import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = prices.length;
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            result[j] = len - j - 1;
        }
        
        return result;
    }
}