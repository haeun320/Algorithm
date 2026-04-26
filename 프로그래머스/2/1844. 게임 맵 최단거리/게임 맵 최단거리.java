import java.util.*;

class Solution {
    class Node {
        int r, c;
        int level;
        Node(int r, int c, int l) {
            this.r = r;
            this.c = c;
            this.level = l;
        }
    }
    
    int[][] map;
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        map = maps;
        n = map.length;
        m = map[0].length;
        
        return bfs();
    }
    
    public int bfs() {
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.r == n-1 && node.c == m-1) {
                return node.level + 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                
                if (!isValid(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                q.add(new Node(nr, nc, node.level + 1));
            }
        }
        
        return -1;
    }
    
    public boolean isValid(int r, int c) {
        return (r >= 0 && r < n && c >= 0 && c < m);
    }
}