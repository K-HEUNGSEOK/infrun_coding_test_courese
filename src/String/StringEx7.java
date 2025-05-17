package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx7 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //회문인지 검사해라
        String str = sc.next();
        if (solution(str)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static boolean solution(String str){
        str = str.toLowerCase();
        int start =0;
        int end = str.length()-1;
        while (end > start){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}