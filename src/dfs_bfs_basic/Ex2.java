package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dfs(n));
    }
    static int dfs(int n){
        if (n == 0){
            return 1;
        }else{
         return n * dfs(n-1);
        }
    }
}
