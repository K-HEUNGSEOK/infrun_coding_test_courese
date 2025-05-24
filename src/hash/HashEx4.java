package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashEx4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();

        System.out.println(solution(a,b));
    }

    static int solution(char[] a , char[] b) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character,Integer> target = new HashMap<>();
        for(int i = 0 ; i < b.length; i ++){
            target.put(b[i], target.getOrDefault(b[i], 0) + 1);
        }
        int lenA = a.length;
        int lenB = b.length;
        int lt = 0, ans = 0;
        for(int rt = 0 ; rt < lenA; rt ++){
            map.put(a[rt], map.getOrDefault(a[rt], 0) + 1);
            if (rt - lt +1 == lenB){
                boolean check = true;
                for (Character key : map.keySet()) {
                    if (!target.containsKey(key)) {
                        check = false;
                        break;
                    }

                    if (target.get(key) != map.get(key)) {
                        check = false;
                        break;
                    }
                }
                if (check){
                    ans ++;
                }
                char left = a[lt++];

                if (map.get(left) == 1) map.remove(left);
                else map.put(left, map.getOrDefault(left , 0) - 1);
            }
        }
        return ans;
    }
}