class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        Queue<int[]> que= new LinkedList<>();
        int fresh=0;
        int time=0;
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    que.add(new int[]{i,j});
                }else if(grid[i][j]==1) fresh++;
            }
        
        int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};

        while(!que.isEmpty() && fresh>0){
            int size=que.size();
            for(int i=0; i< size; i++){
                int[] cur= que.poll();
                int r= cur[0];
                int c= cur[1];
                for(int[] d: dir){
                   int nr= r + d[0];
                   int nc= c + d[1];
                    if(nr>=m || nc>=n || nr<0 || nc<0) continue;
                    if(grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        que.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time: -1;
    }
}