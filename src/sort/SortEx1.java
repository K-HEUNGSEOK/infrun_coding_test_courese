package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SortEx1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        arr = solution(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    static int[] solution(int [] arr){
        for(int i = 0 ; i < arr.length-1; i ++){
            int idx = i;
            for(int j = i + 1; j < arr.length; j ++){
                if (arr[idx] > arr[j]){
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }
}