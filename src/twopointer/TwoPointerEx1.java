package twopointer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointerEx1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0 ; i < n ; i ++){
            a[i] =sc.nextInt();
        }
        int m = sc.nextInt();
        int [] b = new int[m];
        for(int i = 0 ; i < m ; i ++){
            b[i] =sc.nextInt();
        }
        ArrayList<Integer> list  = solution(a,b,n,m);
        for (Integer integer : list) {
            System.out.print(integer +" ");
        }

    }


    static ArrayList<Integer> solution(int[]a,int[]b, int n , int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int pt1 = 0 , pt2 = 0;

        while (pt1 < n && pt2 < m){
            if (a[pt1] > b[pt2]){
                list.add(b[pt2++]);
            }else{
                list.add(a[pt1++]);
            }
        }

        while (pt1 < n) list.add(a[pt1++]);
        while (pt2 < m) list.add(b[pt2++]);
        return list;
    }
}
