package sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortEx7 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coordinate [] coordinates = new Coordinate[n];
        for(int i = 0 ; i < n ; i ++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinates[i] = new Coordinate(x, y);
        }

        Arrays.sort(coordinates, (a, b) -> {
            if (a.x == b.x){
                return a.y - b.y;
            }
            return a.x - b.x;
        });
        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }
    static class Coordinate{
        int x ;
        int y ;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}