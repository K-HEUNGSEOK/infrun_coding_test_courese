package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx11 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
    static String solution(String str) {
        //1. i 하고 i + 1 이 같은지 확인한다.
        //2. cnt = 1이었고 같으면 ++ 한다.
        //3. 같지 않을때 해당 i지점 + cnt를 해주면 된다.
        //4. 이 알고리즘이 가능하려면 맨 뒤에 빈 문자열 하나를 추가로 해준다

        StringBuilder sb = new StringBuilder();
        str += " "; //뒤 문자열에 공백을 추가해준다
        int cnt = 1;
        for(int i = 0 ; i < str.length()-1; i ++){ //-1 안해주면 공백까지감
            if (str.charAt(i) == str.charAt(i+1)){
                cnt ++;
            }else{
                sb.append(str.charAt(i));
                if (cnt > 1){
                    sb.append(cnt);
                    cnt = 1;
                }
            }
        }
        return sb.toString();

    }
}