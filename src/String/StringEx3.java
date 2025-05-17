package String;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringEx3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //문장이 주어지면 제일 긴 단어를 출력하라
        String str = sc.nextLine();
        String[] split = str.split(" ");
        System.out.println(solution(split));
    }
    private static String solution(String[] str){
        String result = "";
        for (String string : str) {
            if (result.length() < string.length()){
                result = string;
            }
        }
        return result;
    }
}