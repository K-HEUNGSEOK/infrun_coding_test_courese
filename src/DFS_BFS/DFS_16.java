package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DFS_16 {
    static int n, m, ans, len;
    static ArrayList<Position> hs, pz;
    static int[] prams;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = Integer.MAX_VALUE;
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                int num = sc.nextInt();
                if (num == 1){
                    hs.add(new Position(i,j));
                }
                if (num == 2){
                    pz.add(new Position(i,j));
                }
            }
        }
        len = pz.size();
        prams = new int[m];
        DFS(0,0);
        System.out.println(ans);
    }
    static void DFS(int l , int s){
        if (l == m){
            int sum = 0;
            for (Position h : hs) {
                int dis = Integer.MAX_VALUE;
                for(int i = 0 ; i < m ; i ++){
                    dis = Math.min(dis, Math.abs(h.x - pz.get(prams[i]).x) + Math.abs(h.y - pz.get(prams[i]).y));
                }
                sum += dis;
            }
            ans = Math.min(ans,sum);
        }else{
            for(int i = s; i <len ; i ++){
                prams[l] = i;
                DFS(l +1 , i + 1);
            }
        }
    }


    static class Position{
        int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
