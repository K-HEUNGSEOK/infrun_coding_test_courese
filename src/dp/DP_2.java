package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DP_2 {
    static int [] dy;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        dy = new int[n+2];
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n+1 ; i ++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        System.out.println(dy[n + 1]);
    }
}
