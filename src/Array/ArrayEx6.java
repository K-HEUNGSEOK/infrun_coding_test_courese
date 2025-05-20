package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class ArrayEx6 {
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            List<Integer> solution = solution(arr);
            for (Integer integer : solution) {
                System.out.print(integer + " ");
            }
        }
        static List<Integer> solution(String[] arr) {
            List<Integer> list = new ArrayList<>();
            int max = 0;
            for (String s : arr) { //문자를 반대로 뒤집어서 리스트에 넣는다.
                String reverse = "";
                for(int i = s.length()-1; i >= 0; i --){
                    reverse += s.charAt(i);
                }
                int number = Integer.parseInt(reverse);
                if (number == 1) continue;
                max = Math.max(max,number);
                list.add(number);
            }
            //소수인지 검사를 해야함
            System.out.println("list = " + list);
            List<Integer> prime = new ArrayList<>();
            for(int i = 0 ; i < list.size(); i ++){
                boolean check = true;
                //제곱근까지 검사를 해야 하는데 < 이렇게 검사한 실수
                for(int j = 2; j <= Math.sqrt(list.get(i)); j ++){
                    if (list.get(i) % j == 0){
                        check = false;
                        break;
                    }
                }

                if (check){
                    prime.add(list.get(i));
                }
            }
            return prime;
        }
    }