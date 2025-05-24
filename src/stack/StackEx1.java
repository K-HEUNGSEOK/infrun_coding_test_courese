package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackEx1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        System.out.println(solution(arr));
    }

    static String solution(char[] arr ){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < arr.length; i++){
            if (arr[i] == '(') {
                stack.push(arr[i]);
            }else {
                if (stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return "YES";
    }
}