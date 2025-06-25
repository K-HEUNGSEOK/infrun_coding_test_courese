package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_8 {
    static int n, m;
    static int[] arr;
    static int[] numberBox;
    static boolean[] ch;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new boolean[n]; //체크는 arr 안에 요소를 체크하는 거기 때문에 n 만큼 생성해야함
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        numberBox = new int[m];
        DFS(0);
    }

    static void DFS(int v) {
        if (v > n) return;
        if (v == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(numberBox[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    numberBox[v] = arr[i]; // 0~ 1까지만 넣어짐 M이 되면 출력 되기 때문에
                    DFS(v + 1);
                    //BOX[0] = arr[0]
                    //BOS[1] = arr[1] 이렇게 되고 DFS(2)가 되면 출력 됨
                    ch[i] = false;
                }
            }
        }
    }
}
