package twopointer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

    public class TwoPointerEx2 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0 ; i < n ; i ++){
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[]b = new int [m];
            for(int i = 0 ; i < m ; i ++){
                b[i]= sc.nextInt();
            }

            ArrayList<Integer> solution = solution(a, b, n, m);
            for (Integer integer : solution) {
                System.out.print(integer +" ");
            }
        }


        static ArrayList<Integer> solution(int[]a,int[]b, int n , int m) {
                Arrays.sort(a);
                Arrays.sort(b);
                ArrayList<Integer> list = new ArrayList<>();
                int p1 = 0, p2 = 0;

                while (p1 < n && p2 < m){
                    if (a[p1] == b[p2]){
                        list.add(a[p1]);
                        p1++;
                        p2++;
                    }

                    else if (b[p2] > a[p1]){
                        p1 ++;
                    }else{
                        p2++;
                    }
                }


            return list;
        }
    }