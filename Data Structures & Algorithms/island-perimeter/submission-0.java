class Solution {
    int m,n;      
    private int bfs(int i, int j, int[][] grid){
        int peri=0;
        Queue<int[]> que= new LinkedList<>();
        que.add(new int[]{i,j});
        grid[i][j]=-1;
        int[][] dire={{1,0},{0,1},{-1,0},{0,-1}};
        while(!que.isEmpty()){
            int[] u= que.poll();
            int r=u[0], c=u[1];
            for(int[] dr: dire){
                int nr= r+dr[0];
                int nc= c+dr[1];
                if(nr>=m || nr<0 || nc<0 || nc>=n || grid[nr][nc]==0) peri++;
                else if(grid[nr][nc]==1){
                    que.add(new int[]{nr,nc});
                    grid[nr][nc]=-1;
                }
            }
        }
        return peri;
    }
    
    public int islandPerimeter(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                   return bfs(i,j,grid);
                    
                }
            }
        }
        return -1;
    }
}