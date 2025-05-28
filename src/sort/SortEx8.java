package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortEx8 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, target, arr));
    }
    static int solution(int n , int target, int [] arr){
        int index = -1;
        //index 는 +1 을 해주어야함
        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;
        while (rt >= lt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == target){
                index = mid + 1;
            }

            if (arr[mid] > target){
                rt = mid -1;
            }else {
                lt = mid + 1;
            }
        }
        return index;
    }
}