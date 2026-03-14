import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end of inputs

        boolean[] visited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(0, 0));

        long result = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) continue;

            visited[cur.v] = true;
            result += cur.cost;
            count++;

            if (count == N) break;

            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                pq.offer(new Node(i, cost[cur.v][i]));
            }
        }

        System.out.println(result);
    }
}