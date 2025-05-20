package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
    static int solution(int n) {
        int [] ch = new int[n+1]; //n + 1 번까지 생성
        int cnt = 0 ;

        for(int i = 2; i <= n ; i ++){
            if (ch[i] == 0){ // 0이면 소수라는 의미임
                cnt ++; //카운트 증가
                for(int j = i ; j <= n ; j += i){// j가 i 배수만큼 돌아야함
                    ch[j] = 1;
                }
            }
        }
        return cnt;

        }
    }