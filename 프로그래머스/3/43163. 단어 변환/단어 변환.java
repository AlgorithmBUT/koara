import java.util.*;

class Solution {
    
    class Word {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
        Queue<Word> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(new Word(begin,0));
        
        boolean canChange = false;
        while(!q.isEmpty()) {
            Word cur = q.poll();
            if(cur.word.equals(target)) {
                canChange = true;
                answer = cur.cnt;
                break;
            }
            answer++;
            for(int idx=0;idx<n;idx++) {
                String nxt = words[idx];
                if(!isDiffOne(cur.word, nxt)) continue;
                if(visited[idx]) continue;
                
                q.offer(new Word(nxt, cur.cnt+1));
                visited[idx] = true;
            }
        }
        
        return canChange ? answer : 0;
    }
    
    boolean isDiffOne(String a, String b) {
        int diff = 0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            } 
        }
        return diff == 1 ? true : false;
    }
}