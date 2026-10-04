import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int n = queue1.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int x: queue1) {
            q1.offer(x);
            sum1 += x;
        }
        for(int x: queue2) {
            q2.offer(x);
            sum2 += x;
        }
        
        int count = 0;
        while(count <= n * 4) {
            if(sum1 == sum2) {
                answer = count;
                break;
            } else if (sum1 < sum2) { // q2 -> q1
                int tmp = q2.poll();
                sum1 += tmp;
                sum2 -= tmp;
                q1.offer(tmp);
            } else { // q1 -> q2
                int tmp = q1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                q2.offer(tmp);
            }
            count++;
        }
        
        return answer;
    }
}