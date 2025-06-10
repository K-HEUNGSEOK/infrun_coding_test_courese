package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_1 {
        static int n;
        static int[] arr;
        static int total;
        static boolean flag = false;
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            arr = new int[n + 1];
            for(int i = 1; i <= n ; i ++){
                arr[i] = sc.nextInt();
                total += arr[i];
            }
            DFS(1,0);
            if (flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
        static void DFS(int L, int sum){
           if (L == n){
               if (flag)return;
               if (sum > total/2) return;
               if (total - sum == sum){
                    flag = true;
               }
           }else{
               DFS(L + 1, sum+arr[L]);
               DFS(L + 1, sum);
           }
        }
    }
