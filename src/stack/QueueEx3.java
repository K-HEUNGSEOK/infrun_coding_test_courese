package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Sick> queue = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i ++){
            queue.offer(new Sick(sc.nextInt(),i));
        }
        System.out.println(solution(n, m, queue));

    }
    static class Sick{
        int r;
        int idx;

        public Sick(int r, int idx) {
            this.r = r;
            this.idx = idx;
        }
    }
    static int solution(int n , int m, Queue<Sick> queue){
        int cnt = 0;

        while (true){
            Sick target = queue.poll();

            boolean check = true;
            for (Sick sick : queue) {
                if (target.r < sick.r){
                    check = false;
                    break;
                }
            }
            if (!check){
                queue.offer(target);
            }else{
                cnt ++;
                if (m == target.idx){
                    return cnt;
                }
            }
        }
    }
}