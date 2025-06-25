package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DFS_5 {
    static int n, target, ans;
    static int[] money;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        money = new int[n];
        for(int i = 0 ; i < n ; i ++){
            money[i] = sc.nextInt();
        }
        //내림차순 정렬 -> 그래야 빨리 찾음
        money = Arrays.stream(money)
                .boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        target = sc.nextInt();
        ans = Integer.MAX_VALUE;
        DFS(0,0,0);
        System.out.println(ans);
    }

   static void DFS(int v , int total , int L ){
        if (v > n) return; // n 을 넘어가면 종료
        if (total > target) return; // 돈이 안맞아도 종료
        if (L >= ans) return; // ans 보다 이미 작으면 종료
        if (total == target){ // 돈이 똑같으면 갱신
            ans = Math.min(ans,L);
        }
        else {
            for(int i = 0 ; i < n ; i ++){
                DFS(v + 1 , total + money[i], L + 1);
            }
        }
   }

}
