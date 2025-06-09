package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TEST {
    static int n , m ;
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> graph ;
    static int[] dis;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //정점의 수가 너무 커지면 행렬은 비효율적이라서 인접리스트를 사용한다.
        //노드 수 N이 크고, 간선 수 M이 적은 희소 그래프
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new boolean[n + 1];
        dis = new int[n + 1];
       graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i ++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BFS(1);
        for(int i = 2; i <= n ;  i++){
            System.out.println(i + " : " + dis[i]);
        }
    }

    static void BFS(int v) {
       ch[v] = true;
       dis[v] = 0;
       queue.offer(v);
       while (!queue.isEmpty()){
           int len = queue.size();
           for(int i = 0 ; i < len ; i ++){
               int cv = queue.poll();
               for(int nv : graph.get(cv)){ //cv 리스트 안에 있는 것들임
                   if (!ch[nv]) { //방문하지않았다면
                       ch[nv] = true;
                       queue.offer(nv);
                       dis[nv] = dis[cv]+1; // 횟수 기입
                   }
               }
           }
       }
    }
}
