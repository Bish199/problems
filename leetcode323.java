//Leetcode 323

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n]; 
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        boolean[] visited =new boolean[n];
        int comp=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                depthFirstSearch(adjList,visited,i);
                comp++;
            }
            
        }
        return comp;

    }
    
    public void depthFirstSearch(List<Integer>[] adjList, boolean[] visited, int idx) {
        visited[idx]=true;
        List<Integer> li=adjList[idx];
        
        for(int k:li){
            if( visited[k]==false)
            depthFirstSearch(adjList,visited,k);
        }
    }
}
