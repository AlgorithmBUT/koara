import java.util.*;

class Solution {
    
    int total;
    Map<Integer, ArrayList<Integer>> graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        total = n;
        
        graph = new HashMap<>();
        for(int[] wire: wires) {
            graph.computeIfAbsent(wire[0], k -> new ArrayList<>()).add(wire[1]);
            graph.computeIfAbsent(wire[1], k -> new ArrayList<>()).add(wire[0]);
        }
        
        for(int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            int cnt1 = bfs(a,a,b);
            int cnt2 = bfs(b,a,b);
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
        }
        
        return answer;
    }
    
    int bfs(int st, int cutA, int cutB) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[total+1];
        q.offer(st);
        visited[st] = true;
        
        int count = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt: graph.getOrDefault(cur, new ArrayList<>())) {
                if((cur == cutA && nxt == cutB) || (cur == cutB && nxt == cutA)) continue;
                if(visited[nxt]) continue;
                q.offer(nxt);
                visited[nxt] = true;
                count++;
            }
        }
        return count;
        
    }
}