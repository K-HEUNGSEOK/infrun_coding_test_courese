package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx12 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }
    static String solution(int n ,String str) {
        //1. “#*****#”를 일곱자리의 이진수로 바꿉니다.
        // #은 이진수의 1로, *이진수의 0으로 변환합니다.
        // 결과는 “1000001”로 변환됩니다.
        //2. 바뀐 2진수를 10진수화 합니다.
        // “1000001”을 10진수화 하면 65가 됩니다.
        //3. 아스키 번호가 65문자로 변환합니다.
        // 즉 아스크번호 65는 대문자 'A'입니다.
        String answer = "";
        char[] arr = str.toCharArray();
        int cnt = 1;
        int index = 0;
        while (n >= cnt){
            // 0 ~ 6
            StringBuilder sb = new StringBuilder();
            for(int i = index; i < cnt * 7; i ++){
                sb.append(arr[i]); //담겼을거임
            }

            String binaryString = binary(sb.toString());
            int number = digit(binaryString);
            answer += String.valueOf((char)number);
            index = cnt * 7; //
            cnt ++;
        }
        return answer;
    }

    private static int digit(String str){
        int num = 0;
        for(int i = 0 ; i < str.length(); i ++){
            num = num * 2 + (str.charAt(i) -'0');
        }
        return num;
    }
    private static String binary(String string) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (c == '#') sb.append('1');
            else if (c == '*') sb.append('0');
        }
        return sb.toString();
    }
}