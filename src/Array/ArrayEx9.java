package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx9 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < n ; j ++){
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println(width(arr,n));



        }
        static int width(int[][] arr, int n ) {
            int max = 0;
            //가로
            for(int i = 0 ; i < n; i ++){
                int num = 0;
                for(int j = 0 ; j < n; j ++){
                    num += arr[i][j];
                }
                max = Math.max(max,num);
            }
            //열의 합
            for(int i = 0 ; i < n ; i ++){
                int num = 0;
                for(int j = 0 ; j < n ; j ++){
                    num += arr[j][i];
                }
                max = Math.max(max,num);
            }

            //왼쪽 대각선의 합
            int line = 0;
            for(int i = 0 ; i < n ; i++){
                line += arr[i][i];
            }
            max = Math.max(max,line);

            int reverseLine = 0;
            for(int i = 0; i < n ; i++){
               reverseLine += arr[i][n-1-i];
            }
            max = Math.max(max,reverseLine);
            return max;
        }
    }