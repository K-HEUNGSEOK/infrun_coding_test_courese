package dp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DP_5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0 ; i < n ; i ++){
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] dy = new int[m+1];
        Arrays.fill(dy,Integer.MAX_VALUE);
        dy[0] = 0;
        //dy배열 정의 : i 금액을 만드는 최소 동전 개수 dy[10] -> 10원을 거슬러주는 최소 동전 갯수
        //0은 0으로 초기화 , 기존 값보다 작으면 변경 , 0 제외하고 MAX_VALUE 로

        for(int i = 0; i < n; i ++){
            //j는 동전의 크기부터 돈다.
            for(int j = coins[i]; j < dy.length; j ++){
                //dy[j] 가 dy[j - coins[i]] 보다 크면
                // dy[j] 는 dy[j-coins[i] + 1 값으로 업데이트
                dy[j] = Math.min(dy[j], dy[j-coins[i]] + 1);
            }
        }
        System.out.println(dy[m]);
    }
}

