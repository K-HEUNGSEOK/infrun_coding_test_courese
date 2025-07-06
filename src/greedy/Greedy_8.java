package greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_8 {
    static int n, m;
    static boolean[] ch ;
    static ArrayList<ArrayList<Edge>> graph;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //priority 큐로 최소 스패닝트리를 할땐 인접리스트, 무방향 그래프가 필요함
        //1차원 체크 배열도 필요함 (정점으로)
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new boolean[n + 1];
        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        int ans = 0;
        queue.offer(new Edge(1,0));

        while (!queue.isEmpty()){
            Edge poll = queue.poll();
            int ev = poll.vex;
            if (!ch[ev]){
                ch[ev] = true;
                ans += poll.cost;
                for (Edge ob : graph.get(ev)) {
                    if (!ch[ob.vex]) queue.offer(new Edge(ob.vex,ob.cost));
                }
            }
        }
        System.out.println(ans);
    }
    static class Edge implements Comparable<Edge>{
        int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}
