package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_10 {
    static int [] b, p , ch;
    static int n , f;
    static boolean flag = false;
    static int[][] graph = new int[35][35];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n]; // 경우의 수 담는 배열
        p = new int[n]; // 수열 담는 배열
        ch = new int[n + 1]; // 방문 체크 배열
        for(int i = 0; i < n ; i++){
            b[i] = combi(n-1, i); //경우의 수를 미리 담아둔다
        }
        DFS(0,0);
    }
    public static int combi(int n, int r){
        if (graph[n][r] > 0) return graph[n][r];
        if (n == r || r == 0) return 1;
        else{ //메모제이셔 활용
             return graph[n][r] = combi(n-1,r-1) + combi(n-1,r);
        }
    }
    public static void DFS(int L , int sum){
        if (flag) return;
        if (sum > f) return;
        if (L == n ){
            if (sum == f){
                for (int i : p) {
                    System.out.print(i + " ");
                }
                flag = true;
                return;
            }
        }else{
            for(int i = 1; i <= n ; i++){
                if (ch[i] == 0){
                    ch[i] = 1;
                    p[L] = i;
                    //경우의 수 * 수열을 하면 시뮬레이션을 하지 않아도 파이널 값이 나온다.
                    //1 ~ N 까지 모든 수열을 만들어보고 경우의 수와 곱해서 결과값을 찾는 것
                    DFS(L + 1 , sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }
}
