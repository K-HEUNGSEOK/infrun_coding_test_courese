package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SortEx2 {
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
        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 0; j < arr.length -1 -i; j ++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}