package Array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayEx10 {
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};
        static int n;
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < n ; j ++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < n ; j ++){
                    int cnt = 0;
                    int target = arr[i][j]; // 비교할 값
                    boolean check = true;
                    for(int k = 0 ; k < 4 ; k ++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (isRange(nx,ny)){
                            cnt ++;
                            if (arr[nx][ny] >= target){
                                check = false;
                                break;
                            }
                        }

                    }
                    if (check && cnt >= 2){
                        ans++;
                    }
                }
            }
            System.out.println(ans);

        }
        static boolean isRange(int x, int y){
            return 0 <= x && x < n && 0 <= y && y < n;
        }

        static void solution(int[][] arr, int n ) {

        }
    }