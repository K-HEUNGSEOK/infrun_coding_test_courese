package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx4_1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            solution(sc.next());
        }
    }
    static void solution(String str){
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i >= 0; i --){
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}