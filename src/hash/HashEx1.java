package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashEx1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        System.out.println(solution(n,arr));
    }

    static char solution(int n ,char [] arr) {
        int max = 0;
        char result = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)  + 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) > max){
                max = map.get(key);
                result =  key;
            }
        }
        return result;
    }
}