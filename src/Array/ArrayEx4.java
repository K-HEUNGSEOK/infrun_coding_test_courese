package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        solution(arr);
    }
    static void solution(int[] arr) {
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2 ; i < arr.length ; i ++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}