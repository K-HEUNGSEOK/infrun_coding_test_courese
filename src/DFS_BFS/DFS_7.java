package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_7 {
    static int n, m, ans;
    static final int MAX_NUM = 8;
    static boolean[][] graph = new boolean[MAX_NUM][MAX_NUM];
    static boolean[][] ch = new boolean[MAX_NUM][MAX_NUM];
    static int[]dx = {-1,0,1,0};
    static int[]dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //*BufferedReader 는 시간제한이 빡센 문제만 사용
        //1. 초기 세팅
        n = 7;
        m = 7;
        ans = 0;
        //1부터 시작하는 이유는 isRange 함수로 따로 인덱스 초과하는지 안봐도 되기 때문
        for(int i = 1; i <= n ; i ++){
            for(int j = 1; j <= m; j ++){
                char input = sc.next().charAt(0);
                if (input == '0'){
                    graph[i][j] = true;
                }
            }
        }
        //2. 함수 호출
        ch[1][1] = true;
        DFS(1,1);
        //3. 출력
        System.out.println(ans);
    }
    static void DFS(int x, int y){
        if (x > n || y > m){
            return;
        }
        if (x == n && y == m){
            ans++;
            return;
        }else{
            for(int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx > n || ny > n) continue;
                if (!ch[nx][ny] && graph[nx][ny]){
                    ch[nx][ny] = true;
                    DFS(nx,ny);
                    ch[nx][ny] = false;
                }
            }
        }
    }
}
