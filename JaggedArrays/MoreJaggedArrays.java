public class MoreJaggedArrays
{
    public static int matSum(int[][] mat){
        int sum = 0;
        for(int[] r : mat)
            if(r!=null)
                for(int c : r)
                    sum += c;
        return sum;
    }
    
    public static int[] searchRay(int[][] mat, int value){
        int[] location = new int[2];
        for(int r = 0; r < mat.length; r++)
            if(mat[r]!=null)
                for(int c = 0; c < mat[r].length; c++)
                    if(mat[r][c] == value){
                        location[0] = r;
                        location[1] = c;
                    }
        return location;
    }
    
    public static int valFrequency(int[][] mat, int value){
        int sum = 0;
        for(int[] r : mat)
            if(r!=null)
                for(int c : r)
                    if(c == value)
                        sum++;
        return sum;
    }
    
    public static void removeVal(int[][] mat, int value){
        for(int r = 0; r < mat.length; r++)
            if(mat[r]!=null)
                for(int c = 0; c < mat[r].length; c++)
                    if(mat[r][c] == value)
                        mat[r][c] = 0;
    }
    
    public static int[] largestRow(int[][] mat){
        int sum = 0;
        for(int r = 0; r < mat.length; r++)
            if(mat[r]!=null)
                for(int c = 0; c < mat[r].length; c++)
                    sum+= mat[r][c];
    }
}
