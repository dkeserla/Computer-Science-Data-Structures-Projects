import java.io.*;
import java.util.Scanner;

public class MagicSquareChecker
{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("magic1.dat"))){
            int lines = Integer.parseInt(reader.readLine());
            for(int i = 0; i < lines; i++){
                int offset = Integer.parseInt(reader.readLine());
                int[] flattened = new int[(int)(Math.pow(offset,2))];
                int j = 0;
                Scanner scanny = new Scanner(reader.readLine());
                while(scanny.hasNext())
                    flattened[j++] = scanny.nextInt();
                
                int[][] mat = makeMat(offset, flattened);
                System.out.println(printMat(mat));
                System.out.println(isMagic(mat) ? "MAGIC SQUARE" : "NOT A MAGIC SQUARE");
            }
        }
        catch(Exception e){}
    }
    
    public static String printMat(int[][] mat){
        String output = "";
        for(int r = 0; r < mat.length; r++){
            output += "\n";
            for(int c = 0; c < mat[r].length; c++)
                output += mat[r][c] + " ";
        }
        return output;
    }
    
    public static int[][] makeMat(int mod, int[] flattened){
        int[][] mat = new int[mod][mod];
        int i = 0;
        for(int r = 0; r < mat.length; r++)
            for(int c = 0; c < mat[r].length; c++)
                mat[r][c] = flattened[i++];
        return mat;
    }
    
    public static boolean isMagic(int[][] mat){
        int[] sums = new int[mat.length*2+2];
        int i = 0;
        
        for(int[] row : mat)
            sums[i++] = getSum(row);
        
        for(int c = 0; c < mat[0].length; c++){
            int[] col = new int[mat.length];
            for(int r = 0; r < mat.length; r++)
                col[r] = mat[r][c];
            sums[i++] = getSum(col);
        }
            
        int[] diag = new int[mat.length];
        for(int d = 0; d < mat.length; d++)
            diag[d] = mat[d][d];
        sums[i++] = getSum(diag);
        
        int[] backDiag = new int[mat.length];
        for(int d = mat.length-1; d > -1; d--)
            backDiag[d] = mat[d][d];
        sums[i++] = getSum(backDiag);    
       
        for(i = 0; i < sums.length-1; i++)
            if(sums[i] != sums[i+1])
                return false;
        return true;
    }
    
    public static int getSum(int[] portion){
        int sum = 0;
        for(int i : portion)
            sum += i;
        return sum;
    }
} 