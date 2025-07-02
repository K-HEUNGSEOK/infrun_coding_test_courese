package greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_7 {
    static int[] unf;
    static ArrayList<Edge> graph;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //최소 스패닝 트리란 그래프에서 트리를 뽑아내는 것 (가중치의 합이 가장 작아야함)
        //그래프는 회로가 존재하고 트리는 존재하지 않음 (간선은 무조건 n-1개)
        //회로는 다시 되돌아올 수 있는 간선들

        //1.각 요소를 담을 수 있는 클래스를 만들고 가중치 오름차 순 정렬한다.
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        unf = new int[n+1];
        for(int i = 1; i <=n ; i++) unf[i] = i;
        graph = new ArrayList<>();

        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.add(new Edge(a,b,c));
        }
        Collections.sort(graph);

        //2.find 로 서로 연결되어있는지 체크한다. 연결되어 있으면 건너뜀
          //회로가 되어버리면 안되기 때문에 연결되면 건너 뛰는 것
        //3.작은값부터 쭉 선택해서 트리가 될 동안 선택하면 된다.
        //선택을 하는 동안 계속 union 으로 같은 집합으로 만들어야한다.
        for (Edge edge : graph) {
            if (find(edge.v1) == find(edge.v2)) continue;

            union(edge.v1,edge.v2);
            ans += edge.cost;
        }
        //4. 출력
        System.out.println(ans);

    }
    static class Edge implements Comparable<Edge>{
        int v1,v2,cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    static int find(int v){
        if (v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }
}
