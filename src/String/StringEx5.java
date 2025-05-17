package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //영어 알파벳만 뒤집고 특수문자는 그대로 둬라
        //65~90 이 대문자
        //97~122 이 소문자
        String str = sc.next();
        System.out.println(solution(str));
    }
    static String solution(String str){
       char[] arr = str.toCharArray();
       int start = 0;
       int end = arr.length-1;

       while (end > start){
         if (!isCheck(arr[start])){
             start++;
         }else if(!isCheck(arr[end])){
             end --;
         }else{
               char tmp = arr[start];
               arr[start] = arr[end];
               arr[end] = tmp;
               start ++;
               end --;
         }

       }
       return new String(arr);
    }
    static boolean isCheck(char str){
        return  ((str >= 65 && str <= 90) || (str >= 97 && str <= 122));
    }
}