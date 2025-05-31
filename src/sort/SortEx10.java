package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortEx10 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        //1. 먼저 정렬한다
        Arrays.sort(arr);
        //2. 두 사이의 거리의 최소값은 1 , 최대값은 정렬 후 끝 값
        int lt = 1;
        int rt = arr[n-1];
        int ans = 0;
        while (rt >= lt){
            int mid = (lt + rt) / 2; // "최소 거리 후보"
            int cnt = 1; //첫 마구간에는 무조건 배치
            int ep =arr[0];
            for(int i = 0 ; i < n ; i ++){
                if (arr[i] - ep >= mid){
                    cnt ++;
                    ep = arr[i];
                }
            }
            if (cnt == m){
                ans = mid;
            }

            if (cnt >= m){
                ans = mid; // 조건 만족 → 정답 후보 저장
                lt = mid + 1; // 거리를 더 늘려보자
            }else{
                rt = mid -1; // 거리가 너무 멀어서 말을 못 넣음 → 좁혀야 함
            }
        }
        System.out.println(ans);
    }

}
