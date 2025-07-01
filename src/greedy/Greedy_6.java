package greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Greedy_6 {
    static int[] unf;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생 수
        int m = sc.nextInt(); //순서 쌍
        unf = new int[n + 1]; // n번까지 나와야함
        for(int i = 1; i <= n ; i++) unf[i] = i; //번호로 초기화

        for(int i = 1; i <=m ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b); //한 집합으로 만들어라!
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if (fa == fb){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static void union(int a, int b){
        int fa = find(a); //3
        int fb = find(b); //4
        if (fa!=fb) unf[fa] = fb;
    }

    //집합 번호를 리턴해줌
    static int find(int v){
        if (v == unf[v]) return v;
        //자신의 부모를 찾을때까지 감
        ////그리고 돌아오면서 부모의 값으로 초기화 (경로 압축)
        return unf[v] = find(unf[v]);
    }
}
