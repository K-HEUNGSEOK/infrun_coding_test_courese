package stack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        char[] target = sc.next().toCharArray();
        char[] arr = sc.next().toCharArray();
        if (solution(target,arr)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    static boolean solution(char[] target, char[] arr) {
        Queue<Character> targetQueue = new ArrayDeque<>();
        //1. 타겟 셋팅 완료
        for(int i = 0 ; i < target.length; i ++){
            targetQueue.offer(target[i]);
        }

        Queue<Character> queue = new ArrayDeque<>();
        for(int i = 0 ; i < arr.length; i ++){
            if (targetQueue.contains(arr[i])){
                queue.offer(arr[i]);
            }
        }
       

        if (queue.size() != targetQueue.size()){
            return false;
        }
        for(int i = 0; i < queue.size(); i ++){
            if (queue.poll() != targetQueue.poll()){
                return false;
            }
        }
        return true;
    }
}