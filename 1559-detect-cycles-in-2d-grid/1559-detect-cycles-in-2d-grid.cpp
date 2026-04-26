// class Solution {
// public:
// int m ;
// int n;
// vector <vector<int>>directions= {{1,0},{0,-1},{-1,0},{0,1}};
//     bool cycleDetect(int r,int c, int prev_r,int prev_c,vector<vector<char>>& grid,
//           vector<vector<bool>>&visited  ){
//             if(visited[r][c]){
//                 return true;
//             }
//             visited[r][c] = true;
//             for(auto &dir : directions){
//                 int new_r = r+dir[0];
//                 int new_c = c+dir[1];

//                 if(new_r >=0 && new_r<m && new_c>=0 && new_c<n &&
//                 grid[r][c] == grid[new_r][new_c]){
//                     if (new_r == prev_r && new_c == prev_c){
//                         continue;
//                     }
//                     if(cycleDetect(new_r,new_c ,r,c, grid,visited)){
//                         return true;
//                     }
//                 }

//             }
//             return false;
//     }
//     bool containsCycle(vector<vector<char>>& grid) {
//          m = grid.size();
//          n  = grid[0].size();
//          vector<vector<bool>>visited (m,vector<bool>(n,false));
//          for(int i =0;i<m;i++){
//             for(int j=0;j<m;j++){
//                 if(!visited[i][j] && cycleDetect(i,j,i,j,grid,visited)){
//                     return true;
//                 }
//             }
//          }
//          return false;
//     }
// };
class Solution {
public:
    int m, n;
    vector<vector<int>> directions = {{1,0},{0,-1},{-1,0},{0,1}};

    bool cycleDetect(int r, int c, int pr, int pc,
                     vector<vector<char>>& grid,
                     vector<vector<bool>>& visited) {

        visited[r][c] = true;

        for (auto &dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                grid[nr][nc] == grid[r][c]) {

                // skip parent
                if (nr == pr && nc == pc) continue;

                // not visited → go deeper
                if (!visited[nr][nc]) {
                    if (cycleDetect(nr, nc, r, c, grid, visited))
                        return true;
                }
                // visited and not parent → cycle
                else {
                    return true;
                }
            }
        }
        return false;
    }

    bool containsCycle(vector<vector<char>>& grid) {
        m = grid.size();
        n = grid[0].size();

        vector<vector<bool>> visited(m, vector<bool>(n, false));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // ✅ fixed
                if (!visited[i][j]) {
                    if (cycleDetect(i, j, -1, -1, grid, visited))
                        return true;
                }
            }
        }
        return false;
    }
};