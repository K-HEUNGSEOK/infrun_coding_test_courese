package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_12 {
    static int n = 8;
    static boolean[][] graph = new boolean[n][n];
    static int[][] direction = new int[10][10];
    static boolean [][] check = new boolean[n][n];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i<=7 ; i++){
            for(int j = 1; j <= 7; j ++){
                int c = sc.nextInt();
                if (c == 0){
                    graph[i][j] = true;
                }
            }
        }
        direction[1][1] = 0;
        BFS(1,1);
        if (direction[7][7] != 0) {
            System.out.println(direction[7][7]);
        }else{
            System.out.println(-1);
        }
    }
    static void BFS(int l , int r){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{l, r});
        int index = 1;
        int cnt = 1;

        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0 ; i < len; i ++){
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for(int j = 0 ; j < 4; j ++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx > 7 || ny > 7) continue;
                    if (!check[nx][ny] &&graph[nx][ny]){
                        check[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                        direction[nx][ny] = direction[x][y] + 1;
                    }
                }
            }
        }

    }
}
