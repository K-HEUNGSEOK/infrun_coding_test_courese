package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Swea_1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int z = 1; z <= T; z ++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            int anInt = getInt(x, y, n);
            System.out.println(anInt);
        }
    }
    static int getInt(int x, int y , int n){
        int cnt = 0;
        while (Math.max(x,y) <= n){
            if (x > y){
                y += x;
            }else{
                x += y;
            }
            cnt ++;
        }
        return cnt;
    }
}