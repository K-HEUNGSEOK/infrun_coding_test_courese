package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DP_3 {
    static int [] dy;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }
    public static int solution(int [] arr){
        dy[0] = 1;
        int ans = dy[0];
        for(int i = 1; i <arr.length; i ++){
            //아무것도 만족하지 못하면 자기 자신만 해야 하는데
            //로직 자체가 max + 1 이기 때문에 max는 0부터 시작
            int max = 0;
            for(int j = i - 1 ; j >= 0 ; j --){
                //arr배열에서 자기보다 작은애들중
                //dy 배열에 기록된애들 중 제일 큰값에서 + 1을 해주는 것
                if (arr[j] < arr[i] && dy[j] > max){
                    max = dy[j];
                }
            }
            dy[i] = max+1;
            ans = Math.max(ans, dy[i]);
        }

        return ans;
    }
}
