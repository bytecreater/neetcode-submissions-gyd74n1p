class Solution {
    class Pair {
        int first;
        int second;

        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    int[] x = {-1,1,0,0};
    int[] y = {0,0,1,-1};

    boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int path = 0;
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    q.offer(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            int s = q.size();
            path++;
            while(s-- > 0){
                Pair p = q.poll();
                int r = p.first;
                int c = p.second;

                for(int k = 0; k < 4; k++){
                    int row = r + x[k];
                    int col = c + y[k];

                    if(isValid(row,col,n,m) && grid[row][col] == 2147483647){
                        grid[row][col] = path;
                        q.offer(new Pair(row,col));

                    }
                }
            }
        }
    }
}
