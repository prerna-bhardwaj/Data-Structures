public class MatrixOnRotation {
    public static boolean findRotation(int[][] mat, int[][] target) {
        if(isEqual(mat, target))
            return true;
        for(int i = 1; i < 4; i++) {
            rotate(mat);
            if(isEqual(mat, target))
                return true;
        }
        return false;
    }
    
    public static void rotate(int[][] a){
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length/2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][a.length - j - 1];
                a[i][a.length - j - 1] = temp;
            }
        }
    } 
    
    public static boolean isEqual(int[][] a, int[][] b) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if(a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0}, 
                        {1, 0}};
        int[][] target = {{1, 1}, 
                        {0, 1}};
        System.out.println(findRotation(mat, target));
    }

}