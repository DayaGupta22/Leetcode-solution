class Solution {
    private void bfs(int i ,boolean[] visited, int[][] isConnected){
        visited[i]= true;
        int n = isConnected.length;
        Queue<Integer>q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for(int j=0;j<n;j++){
                if(isConnected[front][j] ==1 && visited[j] == false){
                    q.add(j);
                    visited[j]=  true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count =0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count=count+1;
                bfs(i,visited,isConnected);
            }
        }
        return count ;
    }
}