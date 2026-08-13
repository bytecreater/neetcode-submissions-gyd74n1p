class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,1,-1};

    boolean isValid(int i, int j, int n,int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }

    void dfs(int[][] heights,boolean visited[][],int i, int j, int n, int m){
        visited[i][j] = true;

        for(int k = 0; k < 4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(isValid(row,col,n,m) && !visited[row][col] && heights[row][col] >= heights[i][j]){
                dfs(heights,visited,row,col,n,m);
            }
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        //Pacific Ocean upper + left
        for(int i = 0; i  < n; i++){
            dfs(heights,pacific,i,0,n,m);
        }

        for(int j = 0; j  < m; j++){
            dfs(heights,pacific,0,j,n,m);
        }

        // Atlantic: right column
        for(int i = 0; i < n; i++){
            dfs(heights, atlantic, i, m - 1, n, m);
        }

        // Atlantic: bottom row
        for(int j = 0; j < m; j++){
            dfs(heights, atlantic, n - 1, j, n, m);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    ans.add(res);
                }
            }
        }
        return ans;
    }
}
