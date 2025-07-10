package dp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DP_6 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //냅색 알고리즘은 무한개면 앞에서 부터 뒤로
        //한개만 있으면 뒤에서부터 앞으로 , 근데 2~3개 있다그러면 어려움
        int n = sc.nextInt();
        int m = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0 ; i < n ; i ++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            students[i] = new Student(s,t);
        }
        int[] dy = new int[m + 1];
        //dy 테이블 끝에서부터 dy [j - pt] 까지 가는거자
        for(int i = 0; i < n ; i ++){
            for(int j = m; j >= students[i].time; j --){
                dy[j] = Math.max(dy[j], dy[j - students[i].time] + students[i].score);
            }
        }

        System.out.println(dy[m]);
    }
    static class Student{
        int score, time;

        public Student(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}

