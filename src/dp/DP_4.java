package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DP_4 {
    static int [] dy;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //밑면 , //높이 // 무게가 주어진다.
        int n = sc.nextInt();
        Rectangle[] rectangles = new Rectangle[n];
        dy = new int[n];
        for(int i = 0 ; i < n ; i++){
            int bottom = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            rectangles[i] = new Rectangle(bottom,height,weight);
        }
        Arrays.sort(rectangles);
        dy[0] = rectangles[0].height; // 높이 처음에 설정
        int ans = dy[0]; //최소 높이

        for(int i = 1; i < n ; i ++){
            int max = 0; //여기에 높이를 더할거임
            for(int j = i -1; j >= 0; j --){
               if (rectangles[i].weight < rectangles[j].weight && max < dy[j]){
                   max = dy[j];
               }
            }
            dy[i] = max + rectangles[i].height;
            ans = Math.max(ans,dy[i]);
        }
        System.out.println(Arrays.toString(dy));
        System.out.println(ans);

    }
    static class Rectangle implements Comparable<Rectangle>{
        int bottom, height, weight;

        public Rectangle(int bottom, int height, int weight) {
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Rectangle o){
            return o.bottom - this.bottom;
        }
    }
}
