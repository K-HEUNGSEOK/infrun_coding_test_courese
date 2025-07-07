package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DP_1 {
    static int [] dy = new int[36];
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //큰 문제가 있을 때 한번에 못푸니까 작은 문제로 나눠서 푸는 것
        //앞에 구해둔 값 (메모제이션) 을 활용해서 큰 문제를 구하는 것 (bottom-up)
        dy[1] = 1;
        dy[2] = 2;
        int n = sc.nextInt();
        for(int i = 3; i <= n ; i ++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        System.out.println(dy[n]);

    }
}
