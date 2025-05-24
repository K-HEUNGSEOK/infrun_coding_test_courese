package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackEx4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        System.out.println(solution(arr));
    }

    static int solution(char[] arr) {
        Stack<Integer> stack = new Stack<>();
        int lt =0 , rt = 0, sum = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if (Character.isDigit(arr[i])) stack.push(Integer.parseInt(String.valueOf(arr[i])));
            else{
                lt = stack.pop();
                rt = stack.pop();
                sum = getNumber(lt,rt,arr[i]);
                stack.push(sum);
            }
        }
        return stack.pop();
    }

    private static int getNumber(int lt, int rt, char c) {
        switch (c){
            case '*':
                return rt * lt;
            case '-':
                return rt - lt;

            case '+':
                return rt + lt;

            case '/':
                return rt / lt;

        }
        return 0;
    }
}