import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int cnt = upperBound(arr, x) - lowerBound(arr,x);
            System.out.println(cnt);
        }
    }

    static int lowerBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static int upperBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > x) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}