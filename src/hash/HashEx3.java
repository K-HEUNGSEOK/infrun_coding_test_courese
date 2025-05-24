package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HashEx3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,k,arr));
    }

    static String solution(int n , int k , int [] arr) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < k ; i ++){
            map.put(arr[i], map.getOrDefault(arr[i],0) +1);
        }
        sb.append(map.size() + " ");
        for(int i = k ; i < n ; i ++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            map.put(arr[i-k], map.getOrDefault(arr[i-k],0) -1);
            if (map.get(arr[i-k]) == 0){
                map.remove(arr[i-k]);
            }
            sb.append(map.size() + " ");
        }
        return sb.toString();
    }
}