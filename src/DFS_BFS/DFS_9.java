package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_9 {
    static int [][] box;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        box = new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }
    static int DFS(int n ,int r){
        //메모제이션 활용
        if (box[n][r] != 0){
            return box[n][r];
        }
        if (n == r || r == 0){
            return 1;
        }else{
            //메모제이션 활용
            return box[n][r] = DFS(n-1, r-1) + DFS(n-1,r);
        }
    }
}
