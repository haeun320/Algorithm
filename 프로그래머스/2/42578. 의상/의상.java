import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int result = 1;
        for (int v : map.values()){
            result *= (v+1);
        }
        
        return result - 1; // 아무것도 선택하지 않는 경우 1 차감
    }
}