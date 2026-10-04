import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            sb.append(binarySearch(arr,x)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == x) {
                return mid+1;
            } else if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}