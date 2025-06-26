package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_15 {
    static int n, ans;
    static boolean[][] graph;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        graph = new boolean[n + 5][n + 5];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    graph[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j]) {
                    ans++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        graph[x][y] = false;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int j = 0; j < 8; j++) {
                int nx = poll[0] + dx[j];
                int ny = poll[1] + dy[j];
                if (graph[nx][ny]) {
                    graph[nx][ny] = false;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
