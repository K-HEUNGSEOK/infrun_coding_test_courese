package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx6 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //중복된 문자는 제거한다.
        String str = sc.next();
        System.out.println(solution(str));;
    }
    static String solution(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i ++){
            //indexOf는 첫 문자의 위치가 나오는걸 이용해서
            //k 의 인덱스가 처음 발견된건 0인데 3, 4 도 k 니까 이건 건너뛰고
            //맞는 것 들만 sb에 넣는 로직임
            if (str.indexOf(str.charAt(i)) == i){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}