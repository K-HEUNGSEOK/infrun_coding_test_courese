package greedy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Wedding> list = new ArrayList<>();

        //도착시간과 떠나는 시간을 같이 입력받는다.
        for(int i = 0 ; i < n ; i ++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Wedding(s,'s'));
            list.add(new Wedding(e,'e'));
        }
        //정렬하고
        Collections.sort(list, (a,b) ->{
            if (a.s == b.s){
                return a.e - b.e;
            }
            return a.s - b.s;
        });

        int cnt = 0 ;
        int ans = 0 ;
        //s면 오는거니까 ++ e면 -- 해서 cnt 가장 큰 값 구하기
        for (Wedding wedding : list) {
            if (wedding.e == 's'){
                cnt ++;
            }else {
                cnt --;
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);

    }
    static class Wedding{
        int s;
        char e;

        public Wedding(int s, char e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Wedding{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }
}
