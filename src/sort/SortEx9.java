package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SortEx9 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        int lt = 0, rt = 0;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
            lt = Math.max(lt, arr[i]);
            rt += arr[i];
        }

        int ans = Integer.MAX_VALUE;
        while (rt >= lt){
            int mid = (lt + rt) / 2;
            int cnt = 1;
            int total = 0;
            for(int i = 0 ; i < n ; i ++){
                if (total + arr[i] > mid){
                    cnt ++;
                    total = arr[i];
                }else {
                    total += arr[i];
                }
            }
            if (cnt <= m){
                ans = Math.min(ans,mid);
                rt = mid -1;
            }else{
                lt = mid + 1;
            }
        }
        System.out.println(ans);
    }

}
