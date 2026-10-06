import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        
        Set<String> set = new HashSet<>();
        for(String gem: gems) {
            set.add(gem);
        }
        int n = set.size();
        
        Map<String, Integer> have = new HashMap<>();
        int left = 0;
        for(int right = 0;right<gems.length;right++) {
            String gem = gems[right];
            have.put(gem, have.getOrDefault(gem,0)+1);
            
            if(have.size() == n) {
                while(have.get(gems[left]) > 1) {
                    have.put(gems[left], have.get(gems[left])-1);
                    left++;
                }
                
                if(answer[1] - answer[0] > right - left) {
                    answer = new int[]{left+1, right+1};
                }
            }
        }
        return answer;
    }
}