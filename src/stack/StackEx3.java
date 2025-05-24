package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackEx3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int [] move = new int[m];
        for(int i = 0 ; i < m ; i ++){
            move[i] = sc.nextInt();
        }

        int [] num = new int[101];

        System.out.println(solution(arr,move,num,m));
    }

    static int solution(int[][] arr, int[] move, int[] num,int m) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0 ;

        for(int i = 0 ; i < m ; i ++){
            int col = move[i] -1;
            
            //이부분도 생각을 잘 못했음,
            //num[col]이 n 을 넘어가면 취소하고 0일땐 계속 건너뛰어야함
            while (num[col] < arr.length && arr[num[col]][col] == 0){
                num[col]++;
            }
            if (num[col] >= arr.length) continue;

            int doll = arr[num[col] ++][col];
            if (!stack.isEmpty() && stack.peek() == doll){
                ans +=2;
                stack.pop(); //여기를 remove 하는 실수함
            }else {
                stack.push(doll);
            }
        }
        return ans;
    }
}