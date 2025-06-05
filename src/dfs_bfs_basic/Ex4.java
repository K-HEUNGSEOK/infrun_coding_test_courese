package dfs_bfs_basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex4 {
    static int n = 3;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }

    static void DFS(int L) {
        if (L == n + 1) {
            String temp = "";
            for(int i = 1; i<= n ; i ++){
                if (ch[i] != 0){
                    temp += (i+"");
                }
            }
            if (temp.length() > 0){
                System.out.println(temp);
            }
        }else{
            ch[L] = 1;
            DFS(L + 1); //얘가 lt (이 원소는 사용한다)
            ch[L] = 0;
            DFS(L + 1); //얘가 rt 라고 생각 (이 원소는 사용 x)
        }
    }
}

