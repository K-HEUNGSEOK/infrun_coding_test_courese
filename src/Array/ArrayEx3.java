package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n ; i ++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n ; i ++){
            b[i] = sc.nextInt();
        }
        solution(a,b);
    }
    static void solution(int[] a, int[] b) {
        for(int i = 0 ; i < a.length; i ++){
            if (a[i] == 1 && b[i] == 3){
                System.out.println("A");
            }
            else if (b[i] == 1 && a[i] == 3){
                System.out.println("B");
            }
            else if (a[i] > b[i]){
                System.out.println('A');
            }else if(b[i] > a[i]){
                System.out.println("B");
            }else{
                System.out.println("D");
            }

        }
    }
}