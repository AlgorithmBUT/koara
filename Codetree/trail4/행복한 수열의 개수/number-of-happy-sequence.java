import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = 0;
        // 가로
        for(int r=0;r<n;r++) {
            if(isHappy(grid[r],m)) answer++;
        }
        // 세로
        for(int c=0;c<n;c++) {
            int[] tmp = new int[n];
            for(int r=0;r<n;r++) {
                tmp[r] = grid[r][c];
            }
            if(isHappy(tmp,m)) answer++;
        }

        System.out.println(answer);
    }

    static boolean isHappy(int[] arr, int m) {
        int cnt = 1;
        if(m == 1) return true;

        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] == arr[i+1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(cnt >= m) return true;
        }
        return false;
    }
}