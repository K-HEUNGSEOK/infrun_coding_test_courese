package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex6 {
    static int answer = 0;
    static int[] dis = {1, -1, 5}; // 이동 거리
    static int[] ch; //체크 배열
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt(); //출발지점
        int target = sc.nextInt(); //타겟
        System.out.println(BFS(start, target));
    }

    static int BFS(int s, int n) {
        ch = new int[10001]; //최대 길이
        ch[s] = 1; //출발 지점 체크
        queue.offer(s);
        int L = 0; //레벨값
        while (!queue.isEmpty()){
            int len = queue.size(); //사이즈
            for(int i = 0 ; i < len; i ++){
                int x = queue.poll(); //root 노드
                for(int j = 0 ; j < 3; j ++){
                    int nx = x + dis[j]; // 1, -1, 5 순서
                    if (nx == n) return L+1; //답이 보이면 리턴
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0){ //경계체크
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L ++;
        }
        return -1;
    }

    static class Node {
        int data;
        Node lt, mt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
            this.mt = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", lt=" + lt +
                    ", rt=" + rt +
                    '}';
        }
    }
}

