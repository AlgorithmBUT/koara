import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int slide = 10;
        
        Map<String, Integer> wants = new HashMap<>();
        Map<String, Integer> disc = new HashMap<>();
        
        for(int i=0;i<number.length;i++) {
            wants.put(want[i], number[i]);
        }
        
        for(int i=0;i<discount.length;i++) {
            if(i >= 10) {
                String key = discount[i-10];
                disc.put(key, disc.get(key)-1);
                if(disc.get(key) == 0) {
                    disc.remove(key);
                }
            }
            disc.put(discount[i], disc.getOrDefault(discount[i], 0) + 1);
            if(disc.equals(wants)) {
                answer++;
            }
        }
        
        return answer;
    }
}