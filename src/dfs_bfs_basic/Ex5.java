package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex5 {
    static Node root;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);

    }
    static void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); //1번째 객체
        int L = 0; //root 레벨
        while (!queue.isEmpty()){ //비어있지 않으면 반복
            int len = queue.size();
            System.out.print(L + " : ");
            for(int i = 0 ; i < len; i ++){
                Node current = queue.poll(); //루트를 빼고 시작
                System.out.print(current.data + " "); //뺀 뒤에 다음 레벨을 담아야함
                if (current.lt != null) { //null 이 아니면
                    queue.offer(current.lt);
                }
                if (current.rt != null){
                    queue.offer(current.rt);
                }
            }
            L ++; //LEVEL 이 끝났으니 증가시켜줘야함
            System.out.println();
        }
    }

    static class Node{
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
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

