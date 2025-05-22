package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx12 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] arr = new int[m][n];
            for(int i = 0 ; i < m ; i ++){
                for(int j = 0 ; j < n ; j ++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0; //짝 수
            for(int i = 1; i <= n ; i ++){
                for(int j = 1; j <=n; j ++){// 여기까지 모든 경우의 수
                    int cnt = 0; //모두 앞서는지 체크
                    for(int k = 0 ; k < m; k ++){
                        int pi = 0 , pj = 0;
                        for(int l = 0 ; l < n ; l ++){
                            if (arr[k][l] == i){
                                pi = l;
                            }
                            if (arr[k][l] == j){
                                pj = l;
                            }
                        }
                        if (pi < pj){
                            cnt ++;
                        }
                    }
                    if (cnt == m){
                        ans ++;
                    }
                }
            }
            System.out.println(ans);
        }

//        static String solution(String str, int n) {
//
//        }
    }