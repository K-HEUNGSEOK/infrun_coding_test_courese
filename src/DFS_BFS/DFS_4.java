package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_4 {
    static int n,m;
    static int[] pm;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m + 1];
        DFS(0);
    }
    static void DFS(int v){
        if (v == m){
            for(int i = 0; i < m; i ++){
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = 1; i <= n; i ++){
                pm[v] = i;
                DFS(v + 1);
            }
        }
    }
}
