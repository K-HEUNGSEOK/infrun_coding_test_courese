package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n);
    }
    static void dfs(int n){
        String answer ="";
        if (n == 0){
            return;
        }else{
        dfs(n / 2);
        System.out.print(n%2);
        }
    }
}
