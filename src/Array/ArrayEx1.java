package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayEx1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }

        for (int i : solution(arr,n)) {
            System.out.print(i + " ");
        }
    }
    static ArrayList<Integer> solution(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i = 1 ; i < n; i ++){
            if (arr[i] > arr[i-1]){
                list.add(arr[i]);
            }
        }
        return list;
    }
}