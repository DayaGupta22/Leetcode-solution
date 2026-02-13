class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length ;
        HashSet<Integer>zeroRow = new HashSet<>();
        HashSet<Integer>zeroCol = new HashSet<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    zeroRow.add(i);
                    zeroCol.add(j);
                }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (zeroRow.contains(i) || zeroCol.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}