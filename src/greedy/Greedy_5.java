package greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_5 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0 ; i <= n ; i ++){
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 0; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        solution(1);
        for(int i = 2; i<= n ; i ++){
            if (dis[i] != Integer.MAX_VALUE){
                System.out.println(i + " : " + dis[i]);
            }else{
                System.out.println(i + " : " + "impossible");
            }
        }

    }
    static void solution(int v){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(v,0)); //1번의 가중치 0을 저장 출발지니까
        dis[v] = 0; //1은 자기 자신이니까 0으로 시작.
        while (!queue.isEmpty()){
            Edge temp = queue.poll();
            int now = temp.vex; //가고자 하는 노드 번호
            int now_cost = temp.cost; // 가고자 하는 노드에 관한 가중치 값
            if (now_cost > dis[now]) continue; //최소값을 찾기 때문에 크면 패스

            for (Edge ob : graph.get(now)) {
                //dis의 값이 now_cost + ob_cost 보다 크면 최소값으로 변경해줌
                if (dis[ob.vex] > now_cost + ob.cost){
                    dis[ob.vex] = now_cost + ob.cost;
                    //변경이 되면 그 값을 큐에 넣어준다.
                    queue.offer(new Edge(ob.vex,now_cost+ob.cost));
                }
            }

        }
    }
    static class Edge implements Comparable<Edge>{
        int vex; //정점 번호
        int cost; //가중치 값

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            //이렇게 하면 우선순위 큐에서 cost가 오름차순인걸 우선순위로 한다.
            return this.cost - o.cost;
        }
    }
}
