package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx9 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //str을 입력 받으면 숫자만 남겨서 그걸 자연수로 만든다.
        //0 1 2 0 5 를 받으면 자연수로 1205 이다
        System.out.println(solution(str));
    }
    static int solution(String str){
        //숫자만 남겨두고 삭제
        str = str.replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }
}