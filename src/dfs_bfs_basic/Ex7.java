package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex7 {
    static Node root;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(0, root));
    }
    static int BFS(int L, Node root){
        if (root.lt == null && root.rt == null){
            return L;
        }else{
            return Math.min(BFS(L + 1 ,root.lt), BFS(L + 1, root.rt));
        }
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
