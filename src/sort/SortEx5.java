package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SortEx5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            int num = sc.nextInt();
            set.add(num);
            list.add(num);
        }
        if (list.size() != set.size()){
            System.out.println("D");
        }else {
            System.out.println("U");
        }

    }
}