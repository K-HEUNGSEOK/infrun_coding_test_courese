package twopointer.slidingwindow;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WindowEx2 {
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
            int sum = 0;
            int ans = 0;
            int start = 0;
            for(int i = 0 ; i < n ; i ++){
                sum += arr[i];

                while (sum > k){
                    sum -= arr[start];
                    start++;
                }

                if (sum == k){
                    ans ++;
                }
            }
            return ans;
        }
    }