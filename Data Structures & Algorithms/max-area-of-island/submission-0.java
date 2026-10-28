class Solution {
    int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        int max=0; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }
    private int dfs(int i,int j, int[][] grid){
        if(i>=m || j>=n || i<0 || j<0 || grid[i][j]==0) return 0;
        int count=1; 
        grid[i][j]=0;
        count+=dfs(i,j+1, grid);
        count+=dfs(i+1,j, grid);
        count+=dfs(i,j-1, grid);
        count+=dfs(i-1,j, grid);
        return count;
    }
}
