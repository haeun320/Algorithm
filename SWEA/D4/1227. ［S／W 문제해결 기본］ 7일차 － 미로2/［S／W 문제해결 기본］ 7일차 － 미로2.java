import java.io.*;
import java.util.*;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
        	String tcn = br.readLine();
        	
        	char[][] maze = new char[100][100];
            int startY = -1;
            int startX = -1;
            
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    maze[i][j] = line.charAt(j);
                    if (maze[i][j] == '2') {
                        startY = i;
                        startX = j;
                    }
                }
            }
            
            int result = bfs(maze, startY, startX);
            
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    
    static int bfs(char[][] maze, int startY, int startX) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        
        queue.add(new Node(startY, startX));
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (maze[current.y][current.x] == '3') {
                return 1;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = current.y + dr[i];
                int nx = current.x + dc[i];
                
                if (ny >= 0 && ny < 100 && nx >= 0 && nx < 100) {
                    if (!visited[ny][nx] && maze[ny][nx] != '1') {
                        visited[ny][nx] = true;
                        queue.add(new Node(ny, nx));
                    }
                }
            }
        }
        
        return 0; 
    }
    
    static class Node {
        int y, x;
        
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}