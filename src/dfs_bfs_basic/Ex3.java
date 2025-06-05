package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex3 {
    Node root;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
//        Scanner sc = new Scanner(System.in);
        Ex3 tree = new Ex3();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt = new Node(3);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        DFS(tree.root);
    }
    static void DFS(Node root){
        if (root == null) return; //말단노드까지 온것
        else{
//            System.out.print(root.data + " "); //여기는 전위순회 (부모 -> 왼쪽 -> 오른쪽)
            DFS(root.lt); //왼쪽으로
//            System.out.print(root.data + " "); //여기는 중위순회 (왼조 -> 부모 -> 오른쪽)
            DFS(root.rt); //오른쪽으로
            System.out.print(root.data + " "); //여기는 후외순회 (왼쪽 -> 오른쪽 -> 부모)
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

