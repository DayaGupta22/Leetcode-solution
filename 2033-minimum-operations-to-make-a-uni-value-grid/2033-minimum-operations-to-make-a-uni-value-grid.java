class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int p = m*n;
        int[] arr = new int[p];
        int i=0;
        for (int row[] :grid){
            for(int num:row){
                arr[i]= num;
                i++;
            }
        }
        int mod = arr[0]%x;
        for(int num :arr){
            if (num%x != mod){
                return -1;

            }
        }
        Arrays.sort(arr);
        int mid = arr[p/2];
        int operations = 0;
        for (int num :arr){
            operations += Math.abs(num-mid);
        }
        return operations/x;
    }
}