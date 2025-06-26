package DFS_BFS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DFS_11 {
    static int n, m;       // n: 전체 원소 개수, m: 뽑을 원소 개수
    static int[] p;        // 현재까지 뽑은 조합을 저장할 배열
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력: n과 m 읽기
        n = sc.nextInt();
        m = sc.nextInt();

        // 조합을 담을 배열 크기 m으로 초기화
        p = new int[m];

        // DFS 탐색 시작: 아직 아무것도 뽑지 않은 상태(level=0),
        // 다음에 뽑을 수 있는 최소 숫자는 1(start=1)
        dfs(0, 1);
    }

    /**
     * @param level 현재까지 뽑은 원소 수 (=다음에 p[level]를 채울 차례)
     * @param start 이번 위치에서 최소로 뽑을 수 있는 숫자
     */
    static void dfs(int level, int start) {
        // 기저 조건: m개를 모두 뽑았으면 조합 하나 완성
        if (level == m) {
            // 완성된 조합 출력
            for (int x : p) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;  // 더 이상 탐색할 부분이 없음
        }

        // 아직 덜 뽑은 경우:
        // start부터 n까지 숫자를 차례로 시도
        // → 이 순서를 유지하면 p 배열이 항상 오름차순이 보장됨
        for (int i = start; i <= n; i++) {
            p[level] = i;           // level 위치에 i를 선택
            dfs(level + 1, i + 1);  // 다음 레벨로 내려가되,
            // 다음에는 i+1 이상의 숫자만 고를 수 있도록 start=i+1 지정
        }
    }
}
