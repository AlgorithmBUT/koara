import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int tan: tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        int n = tangerine.length - k;
        int idx = 0;
        for(Map.Entry<Integer,Integer> e: list) {
            int val = e.getValue();
            if(val <= n) {
                n -= val;
                idx++;
            } else {
                break;
            }
        }
        return list.size() - idx;
    }
}