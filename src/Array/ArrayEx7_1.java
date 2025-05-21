package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx7_1 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[]arr = new int[n];
            for(int i = 0 ; i < n ; i ++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(arr));


        }
        static int solution(int[] arr) {
           //1.답이 1이면 끊기지 않으면 1 + 2 + 3 인데 끊기면 다시 0;
            //2. 총 점을 구하라!
            int ans = 0;
            int cnt = 0;
            for(int i = 0 ; i < arr.length; i ++){
                if (arr[i] == 1){
                    cnt ++;
                    ans += cnt;
                }else {
                    cnt = 0;
                }
            }
            return ans;
        }


    }