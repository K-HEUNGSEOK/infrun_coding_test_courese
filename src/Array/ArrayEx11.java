package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx11 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] arr= new int[n][5];
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < 5 ; j ++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            int index = -1;
            for(int i = 0 ; i < n ; i ++){
                int cnt = 0;
                boolean[] check = new boolean[n + 1];
                for(int j = 0 ; j < 5; j ++){
                    int target = arr[i][j];
                    for(int k =0; k < n ; k ++){
                        if (k == i) continue;
                        if (arr[k][j] == target){
                            check[k] = true;
                        }
                    }
                }
                for(int l  = 0 ; l < check.length; l ++){
                    if (check[l]) cnt ++;
                }

                if (cnt > ans){
                    ans = cnt;
                    index = i;
                }
            }
            if (ans == 0){
                System.out.println(1);
                System.exit(0);
            }
            System.out.println(index + 1);

        }

//        static String solution(String str, int n) {
//
//        }
    }