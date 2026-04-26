import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> score = new PriorityQueue<>();
        for (int i : scoville) {
            score.offer(i);
        }
        
        int cnt = 0;
        
        while (score.peek() < K) {
            if (score.size() < 2) {
                return -1;
            }
            
            int first = score.poll();
            int second = score.poll();
            score.offer(first + second * 2);
            cnt++;
        }
        return cnt;
    }
}