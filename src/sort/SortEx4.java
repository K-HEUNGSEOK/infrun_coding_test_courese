package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class SortEx4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> solution = solution(n, m, sc);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
    }
    static LinkedList<Integer> solution(int n , int m, Scanner sc) {

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < m ; i ++){
            int num = sc.nextInt();

            if (list.contains(num)){
                //여기서 Integer 로 형변환 하지 않으면
                //num 이 아닌 num 번째 인덱스를 삭제하게됨
                list.remove((Integer)num);

                list.addFirst(num);
            }
            else {
                if (list.size() == n){
                    list.removeLast();
                }
                list.addFirst(num);
            }
        }
        return list;
    }
}