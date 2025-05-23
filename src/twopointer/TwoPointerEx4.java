package twopointer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TwoPointerEx4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n,k,arr));
    }

    static int solution(int n , int k , int [] arr) {
        int ans = 0 , lt = 0, sum = 0, cnt =0;
        for(int rt = 0; rt < n ; rt ++){
            if (arr[rt] == 0)cnt ++; //바로 sum 을 계산하지 않는다
            while (cnt > k){ //여기서 초과가 됐는지 확인을 한 후에
                if (arr[lt] == 0) cnt --;
                lt ++;
            }
            sum = rt - lt + 1; // 여기서 길이를 계산한다.
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}