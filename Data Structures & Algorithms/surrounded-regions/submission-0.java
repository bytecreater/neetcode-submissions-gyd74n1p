class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,1,-1};

    boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }

    void dfs(char[][] board, int i, int j, int n, int m, boolean[][] visited){
        visited[i][j] = true;
        for(int k = 0; k < 4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(isValid(row,col,n,m) && board[row][col] == 'O' && !visited[row][col]){
                dfs(board,row,col,n,m,visited);
            }
        }
    }


    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j  == m - 1){
                    if(board[i][j] == 'O' && !visited[i][j]){
                        dfs(board,i,j,n,m,visited);
                    }
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
