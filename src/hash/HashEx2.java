package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashEx2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();

        if (solution(a,b)) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean solution(char[] a , char[] b) {
        if (a.length != b.length) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < a.length; i ++){
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for(int i = 0 ; i < b.length; i ++){
            if (!map.containsKey(b[i])) return false;

            map.put(b[i], map.getOrDefault(b[i], 0) -1);
        }
        for (Integer value : map.values()) {
            if (value != 0){
                return false;
            }
        }
        return true;
    }
}