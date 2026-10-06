import java.util.*;

class Solution {
    
    char[] num;
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        num = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        int idx = 0;
        for(char n: numbers.toCharArray()) {
            num[idx++] = n;
        }
        dfs("");
        
        for(int s: set) {
            if(isPrime(s)) answer++;
        }
        
        return answer;
    }
    
    void dfs(String cur) {
        if(!cur.isEmpty()) {
            int tmp = Integer.parseInt(cur);
            set.add(tmp);
        }
        
        for(int i=0;i<num.length;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(cur + String.valueOf(num[i]));
            visited[i] = false;
        }
    }
    
    boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2;i*i<=n;i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}