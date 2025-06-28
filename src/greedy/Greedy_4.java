package greedy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        ArrayList<Money> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            int m = sc.nextInt();
            int t =sc.nextInt();
            if (max < t ){
                max = t; //가장 큰 날짜 찾기
            }
            list.add(new Money(m,t));
        }
        Collections.sort(list, (a,b) -> b.time-a.time);


        //기본값이 최소값 우선이기 때문에 reverseOrder 로 큰값 우선으로 해줌
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;

        int j = 0; //j를 안에 넣으면 0 으로 계속 초기화가 돼서 밖으로 뺀거임
        //안에 j 를 넣으면 60만 계속 나옴

        for(int i = max; i >= 1; i --){
            for(; j < n; j ++){
                //날짜가 i보다 작으면 멈추기
                if (list.get(j).time < i){
                    break;
                }else{
                    //그게 아니면 넣어주기
                    queue.add(list.get(j).m);
                }
            }
            //비어있으면 예외 터지니 안전장치
            if (!queue.isEmpty()){
            result += queue.poll();
            }
        }
        System.out.println(result);

    }
    static class Money{
        int m,time;

        public Money(int m, int time) {
            this.m = m;
            this.time = time;
        }

    }
}
