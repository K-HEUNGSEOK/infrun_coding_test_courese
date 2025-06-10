package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DFS_3 {
    static int n, m, ans;
    static int [] a;
    static int [] b;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[ n + 1];
        b = new int[ n + 1];
        for(int i = 1 ; i <= n ; i ++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        DFS(1,0,0);
        System.out.println(ans);
    }

    static void DFS(int v, int num, int time) {
        if (v > n){
            if (time > m){
                return;
            }
            else{
                ans = Math.max(ans,num);
            }
        }else{
            DFS(v+1, num + a[v], time + b[v]);
            DFS(v+1, num, time);
        }
    }
}
