import java.io.*;
import java.util.*;

public class Solution {
    private static int N;
    private static int result;
    private static int[] cols;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            cols = new int[N];
            
            backtrack(0);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void backtrack(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                cols[row] = col;
                backtrack(row + 1);
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;
            
            // 대각선에 있는지 체크 (행 차이 == 열 차이)
            if (Math.abs(row - i) == Math.abs(col - cols[i])) return false;
        }
        return true;
    }
}