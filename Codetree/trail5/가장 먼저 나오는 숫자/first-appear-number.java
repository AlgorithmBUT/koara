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
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }
        for(int query: queries) {
            System.out.println(lowerBound(arr, query));
        }
    }

    static int lowerBound(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x) right = mid;
            else left = mid +1;
        }
        if(left < arr.length && arr[left] == x) {
            return left+1;
        } 
        return -1;
    }
}