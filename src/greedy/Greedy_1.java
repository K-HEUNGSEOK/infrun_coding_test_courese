package greedy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for(int i = 0 ; i < n ; i ++){
            int height = sc.nextInt();
            int weight = sc.nextInt();
            students[i] = new Student(height,weight);
        }
        Arrays.sort(students, (a,b) -> b.height - a.height);
        int cnt = 1 ;
        int max = students[0].weight ;
        for(int i = 1 ; i < n ; i ++){
            if (students[i].weight > max){
                max = students[i].weight;
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
    static class Student{
        int height, weight;

        public Student(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

    }
}
