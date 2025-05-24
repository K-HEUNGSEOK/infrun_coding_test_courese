package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackEx5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        System.out.println(solution(arr));
    }

    static int solution(char[] arr) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < arr.length; i ++){
            if (arr[i] == '(') stack.push(arr[i]);
            else {
                if (arr[i -1] == '('){
                    //이거면 레이저임
                    stack.pop();
                    ans += stack.size();
                }else {
                    stack.pop();
                    ans +=1;
                }
            }
        }
        return ans;
    }
}