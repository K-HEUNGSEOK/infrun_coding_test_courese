package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx8 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[]arr = new int[n];
            for(int i = 0 ; i < n ; i ++) {
                arr[i] = sc.nextInt();
            }
            int[] solution = solution(arr,n);
            for (int i : solution) {
                System.out.print(i + " ");
            }


        }
        static int[] solution(int[] arr, int n) {
            int [] count = new int[n];
            for(int i = 0 ; i < n; i ++){
                int cnt = 1; //미리 1등으로 해둔다
                for(int j = 0 ; j < n ; j ++){
                    if (i == j ) continue;

                    if (arr[i] < arr[j]){ //자기보다 큰애면 순위를 높인다
                        cnt ++;
                    }
                }
                count[i] =  cnt ;
            }
            return count;
        }
    }