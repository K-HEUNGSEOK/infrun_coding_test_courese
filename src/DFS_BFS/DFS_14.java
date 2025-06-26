package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_14 {
    static int n, ans;
    static boolean[][] graph;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        graph = new boolean[n +5 ][n + 5];

        for(int i = 1; i <= n ; i ++){
            for(int j = 1 ; j <= n ; j ++){
                int num = sc.nextInt();
                if (num == 1){
                    graph[i][j] = true;
                }
            }
        }

        for(int i = 1; i <=n ;i ++){
            for(int j = 1; j <= n; j++){
                if (graph[i][j]){
                    ans ++;
                    DFS(i,j);
                }
            }
        }
        System.out.println(ans);
    }
    static void DFS(int x, int y){
        if (x > n || y > n){
            return;
        }else{
            for(int i = 0 ; i < 8; i ++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (graph[nx][ny]){
                    graph[nx][ny] = false;
                    DFS(nx,ny);
                }
            }
        }
    }
}
