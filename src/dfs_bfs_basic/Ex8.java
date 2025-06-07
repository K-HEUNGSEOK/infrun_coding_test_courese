package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex8 {
    static Node root;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
    }
    static int BFS(Node root){
       int L = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i ++){
                Node current = queue.poll();
                if (current.lt == null && current.rt == null){
                    return L;
                }
                if (current.lt != null){
                    queue.offer(current.lt);
                }
                if (current.rt != null){
                    queue.offer(current.rt);
                }

            }
            L ++;
        }
        return -1;
    }

    static class Node {
        int data;
        Node lt , rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }
    }
}
