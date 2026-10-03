import java.util.Scanner;
public class Main {

    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int r=0;r<n-2;r++) {
            for(int c=0;c<n-2;c++) {
                answer = Math.max(answer, check(r,c));
            }
        }
        System.out.println(answer);
    }

    static int check(int x, int y) {
        int count = 0;
        for(int i=x;i<x+3;i++) {
            for(int j=y;j<y+3;j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}