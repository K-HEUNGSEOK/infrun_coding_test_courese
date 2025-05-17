package String;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringEx2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //대문자와 소문자가 같이 오는데 각각변환해라
        char[] arr = sc.next().toCharArray();

        solution(arr);
        System.out.println(arr);
    }

    private static void solution(char[] arr) {
        for(int i = 0; i < arr.length; i ++){
            if (arr[i] >= 65 && arr[i] < 97){
                arr[i] = (char) (arr[i] - 'A' + 'a');
            }else {
                arr[i] = (char) (arr[i] - 'a' + 'A');
            }
        }
    }
}