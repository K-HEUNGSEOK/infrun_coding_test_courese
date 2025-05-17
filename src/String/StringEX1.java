package String;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringEX1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char target = sc.next().charAt(0);
        System.out.println(solution(str, target));
    }
    static int solution(String str, char target){
        int count = 0;
        str = str.toLowerCase();
        if (target < (char)97){
            target = (char) (target + 32);
        }
        for(int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == target ){
                count ++;
            }
        }
        return count;
    }
}