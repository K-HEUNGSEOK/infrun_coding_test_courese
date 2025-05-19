package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx8 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (solution(str)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static boolean solution(String str){
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (Character.isAlphabetic(c)){
                sb.append(c);
            }
        }
        String current = sb.toString();
        String reverse = sb.reverse().toString();
        if (current.equals(reverse)){
            return true;
        }
        return false;
    }
}