package twopointer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TwoPointerEx3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    static int solution(int n) {
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = i;
        }
        int ans = 0, sum = 0, lt = 1;
        for(int rt = 1; rt < n ; rt ++){
            sum += arr[rt];
            if (sum == n){
                ans ++;
            }

            while (sum >= n){
                sum -= arr[lt ++];
                if (sum == n){
                    ans ++;
                }
            }
        }
        return ans;
    }
}