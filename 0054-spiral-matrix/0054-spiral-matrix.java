class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer >result = new ArrayList<>();
        int top =0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix [0].length -1;
        while (left<= right && top <= bottom){
            // first movement left-> right (top row)
            for (int i=left ; i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            // top to bottom (right last colums)
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            } right--;
            // right  to left (last row)
            if(top<=bottom){
               for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            // bottom to top  (first column)
              if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
           
        }
        return result;
    }
}