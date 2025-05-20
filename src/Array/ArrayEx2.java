package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        int cnt = solution(arr,n);
        System.out.println(cnt);
    }
    static int solution(int[] arr, int n) {
        int ans = 1;
        int max = arr[0];
        for(int i = 1 ; i < n ; i ++){
            if (max < arr[i]){
                max = arr[i];
                ans ++;
            }
        }
        return ans;
    }
}