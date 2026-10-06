import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0, b = 0;
        int n = A.length;
        while(a < n && b < n) {
            if(B[b] > A[a]) {
                a++;
                b++;
                answer++;
            } else {
                b++;
            }
        }
        
        return answer;
    }
}