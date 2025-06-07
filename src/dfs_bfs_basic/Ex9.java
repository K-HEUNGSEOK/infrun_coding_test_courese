package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex9 {
    static boolean[] ch;
    static int[][] graph;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new boolean[n + 1];
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= n ; j ++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        ch[1] = true; //시작 체크
        DFS(1);
        System.out.println(ans);
    }
    static void DFS(int V){
        if (V == n) ans++;
        else{
            for(int i = 1; i<=n ; i ++){
                if (graph[V][i] == 1 && !ch[i]){
                    ch[i] = true;
                    DFS(i);
                    ch[i] = false; //back 하는 지점
                }
            }
        }
    }


}
