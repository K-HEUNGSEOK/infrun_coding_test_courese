package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex10 {
    static int n , m , ans;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //정점의 수가 너무 커지면 행렬은 비효율적이라서 인접리스트를 사용한다.
        //노드 수 N이 크고, 간선 수 M이 적은 희소 그래프
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new boolean[n + 1];
        graph = new ArrayList<>(new ArrayList<>()); // 첫 생성
        for(int i = 0 ; i < n ; i ++){
            graph.add(new ArrayList<>()); //나머지 생성
        }
        for(int i = 0 ; i < m ; i ++){ //이렇게 해야 0부터 생성한다. 0 ~ n 까지
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); //a번 리스트에 b를 추가한다.
        }
        ch[1] = true;
        DFS(1);
        System.out.println(ans);
    }

    static void DFS(int V) {
        if (V == n) ans ++;
        else{
            for (int nv : graph.get(V)) { //V번 리스트의 각 값들이 나옴
                if(!ch[nv]) {
                    ch[nv] = true;
                    DFS(nv);
                    ch[nv] = false;
                }
            }
        }
    }
}
