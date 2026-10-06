import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        // Please write your code here.

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(long x=a;x<=b;x++) {
            int cnt = binarySearch(m, x);
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }
        System.out.println(min + " " + max);
    }

    static int binarySearch(long m, long x) {
        long left = 1;
        long right = m;
        int count = 1;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid == x) {
                return count;
            } else if(mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            count++;
        }
        return count;
    }
}