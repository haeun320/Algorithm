import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 작업 일수 배열
        int len = progresses.length;
        int[] days = new int[len];
        for (int i = 0; i < len; i++) {
            days[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        int p = 0;
        int pending = 0;
        
        List<Integer> result = new ArrayList<>();
        for (int q = 1; q < len; q++) {
            if (days[p] < days[q]) {
                result.add(pending + 1);
                pending = 0;
                p = q;
                continue;
            }
            pending++;
        }
        result.add(pending+1);
        
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
}