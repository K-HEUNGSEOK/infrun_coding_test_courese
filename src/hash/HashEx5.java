package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class HashEx5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i ++){
            arr[i]= sc.nextInt();
        }
        System.out.println(solution(arr,k));
    }

    static int solution(int[] arr , int k ){
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = i + 1; j < arr.length; j ++){
                for(int l = j + 1; l < arr.length; l ++){
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer x : set) {
            cnt ++;

            if (cnt == k){
                return x;
            }
        }
        return -1;
    }
}