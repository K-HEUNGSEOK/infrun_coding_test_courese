package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_2 {
    static int c , n, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        ans = 0 ;
        arr = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            arr[i] = sc.nextInt();
        }
        //1.하나씩 다 합쳐보면서 c보다 크면 안됨
        //2.c보다 작은 것 중에 제일 큰 수를 찾아보자
        DFS(1,0);
        System.out.println(ans);
    }

    static void DFS(int L, int sum) {
        if(L == n+1){
            if (sum > c){
                return;
            }else{
                ans = Math.max(ans,sum);
            }
        }else{
            DFS(L + 1, sum+arr[L]);
            DFS(L + 1 ,sum);
        }
    }
}
