package String;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StringEx10 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        //첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
        int[] solution = solution(s, t);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
    static int[] solution(String s, char t){
        //1. 왼족에서 탐색
        //2. 오른쪽에서 탐색
        //3. 둘 중 작은걸
        int[] arr = new int[s.length()];
        int p = 1000;
        for(int i = 0 ; i < s.length(); i ++){
            if (s.charAt(i) == t){
                p = 0;
            }else{
                p ++;
            }
            arr[i] = p;
        }

        for(int i = s.length()-1; i>= 0; i --){
            if (s.charAt(i) == t){
                p = 0;
            }else{
                p ++;
            }
            arr[i] = Math.min(arr[i], p);
        }
        return arr;
    }
}