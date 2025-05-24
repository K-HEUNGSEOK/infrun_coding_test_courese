package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackEx2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    static String solution(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=  0 ; i < str.length();  i++){
            char target = str.charAt(i);
            if (target != '(' && target != ')' && stack.isEmpty()){
                sb.append(target);
            }
            else if(target == '('){
                stack.push(target);
            }else if(target == ')'){
                stack.pop();
            }
        }
        return sb.toString();
    }
}