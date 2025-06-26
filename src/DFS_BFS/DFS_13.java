package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_13 {
    static int n, m;
    static int[][] date;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        date = new int[n][m ];
        graph = new int[n][m];

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                int num = sc.nextInt();
                if (num == 1){
                    queue.offer(new int[]{i,j});
                }
                graph[i][j] = num;
            }
        }
        BFS();
        boolean flag = true;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if (graph[i][j] == 0){
                    flag = false;
                }
            }
        }
        int ans =Integer.MIN_VALUE ;
        if (flag){
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < m ; j ++){
                    ans = Math.max(ans,date[i][j]);
                }
            }
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }
    }
    static void BFS(){
        while (!queue.isEmpty()){
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                for(int j = 0 ; j < 4;  j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < n && nx >= 0 && ny < m && ny >= 0 && graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        date[nx][ny] = date[x][y] + 1;
                    }
                }
            }
        }
    }
