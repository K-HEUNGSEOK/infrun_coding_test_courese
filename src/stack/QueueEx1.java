package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }

    static int solution(int n , int k) {
       Queue<Integer> queue = new ArrayDeque<>();
       for(int i = 1 ; i <= n;  i ++){
           queue.offer(i);
        }
       int ans = 0;
       while (!queue.isEmpty()){
           for(int i = 1; i < k ; i ++){
               queue.offer(queue.poll()); //k 전까지 앞으로 옮기고
           }
           queue.poll(); //k번째 숫자를 제거함
           if (queue.size() == 1){
               ans = queue.poll(); //마지막 숫자는 담는다
           }
       }
       return ans;
    }
}