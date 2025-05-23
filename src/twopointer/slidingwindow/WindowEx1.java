package twopointer.slidingwindow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WindowEx1 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i ++){
                arr[i] = sc.nextInt();
            }
            int ans = solution(arr,n,k);
            System.out.println(ans);
        }


        static int solution(int [] arr, int n , int k) {
            int total = 0;
              for(int i = 0 ; i < k ; i ++){
                  total += arr[i]; // 이게 첫번째 윈도우
              }

              int ans = total;
              for(int i = k ; i < n ; i ++){
                  total += arr[i] - arr[i - k];
                  ans = Math.max(ans,total);
              }
              return ans;
        }
    }