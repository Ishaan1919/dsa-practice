public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int rowOne = 0;
        int colOne = 0;
        int n = matrix.length; // no of rows
        int m = matrix[0].length; // no of cols

        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                rowOne++;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                colOne++;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowOne>0){
            for(int i=0;i<m;i++) matrix[0][i] = 0;
        }
        if(colOne>0){
            for(int i=0;i<n;i++) matrix[i][0] = 0;
        }

    }
}
