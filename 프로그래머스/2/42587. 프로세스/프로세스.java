import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer> queue = new ArrayDeque<>();
        Integer[] sortedPriorities = new Integer[priorities.length];
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            sortedPriorities[i] = priorities[i];
        }
        Arrays.sort(sortedPriorities, Comparator.reverseOrder());
        
        List<Integer> order = new ArrayList<>();
        int top = 0;
        int result = 0;
        
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (priorities[idx] == sortedPriorities[top]) {
                order.add(idx);
                top++;
                result++;
                
                if (idx == location) {
                    return result;
                }
                continue;
            }
            queue.offer(idx);
        }
        
        return result;
    }
}