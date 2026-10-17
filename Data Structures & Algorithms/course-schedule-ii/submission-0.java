class Solution {
    Stack<Integer> stack= new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n= numCourses;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int e[]: prerequisites){
            int u= e[1];
            int v= e[0];
            adj.get(u).add(v);
        }
        boolean[] visited= new boolean[n];
        boolean[] path= new boolean[n];
        
        for(int i=0; i<n; i++)
            if(!visited[i] && dfs(i,adj,visited,path)) return new int[0];
        
        int[] res= new int[n];
        for(int i=0; i<n; i++)
            res[i]= stack.pop();
        
        return res;

    }
    private boolean dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path){
        visited[u]=true;
        path[u]=true;
        for(int v: adj.get(u)){
            if(!visited[v] && dfs(v,adj, visited, path)) return true;
            else if(path[v]) return true;
        }
        path[u]=false;
        stack.push(u);
        return false;
    }
}
