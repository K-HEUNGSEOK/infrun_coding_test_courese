package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SortEx3 {
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
        for(int i = 1; i < arr.length; i ++){
            // j가 다 돌고 + 1 해서 넣어야하기 때문에 j를 위에다 선언
            int temp = arr[i], j;
            for(j = i -1 ; j >= 0; j --){
                if (arr[j] > temp){
                    arr[j+1] = arr[j]; //뒤쪽으로 밀어줌
                }else break; //아니면 멈추고 그 뒷자리에 넣어야함
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}