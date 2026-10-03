class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        
        int left = 0;
        int sum = 0;
        for(int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while(sum > k) {
                sum -= sequence[left++];
            }
            
            if(sum == k && answer[1]  - answer[0] > right - left) {
                answer = new int[]{left, right};
            }
        } 
        
        return answer;
    }
}