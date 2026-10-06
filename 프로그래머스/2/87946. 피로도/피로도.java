class Solution {
    
    int n;
    int answer = 0;
    boolean[] visited;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        dfs(k,0);
        
        return answer;
    }
    
    void dfs(int tired, int count) {
        answer = Math.max(answer, count);
        
        for(int i=0;i<n;i++) {
            if(visited[i]) continue;
            int[] dungeon = dungeons[i];
            if(dungeon[0] <= tired) {
                visited[i] = true;
                dfs(tired-dungeon[1],count+1);
                visited[i] = false;
            }
        }
    }
}