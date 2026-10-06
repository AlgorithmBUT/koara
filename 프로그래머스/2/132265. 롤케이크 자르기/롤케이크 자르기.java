import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> front = new HashSet<>();
        Map<Integer,Integer> back = new HashMap<>();
        for(int t: topping) {
            back.put(t, back.getOrDefault(t,0) + 1);
        }
        
        for(int t: topping) {
            front.add(t);
            back.put(t, back.get(t)-1);
            
            if(back.get(t) == 0) {
                back.remove(t);
            }
            
            if(front.size() == back.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}