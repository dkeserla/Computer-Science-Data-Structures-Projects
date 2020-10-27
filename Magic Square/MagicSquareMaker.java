import java.io.*;
import java.util.Scanner;

public class MagicSquareMaker
{
    public static void main(String[] args){
       try(BufferedReader reader = new BufferedReader(new FileReader("magic2.dat"))){
           String line;
           while((line = reader.readLine()) != null)
               System.out.println(printMat(makeSquare(Integer.parseInt(line))));
        }
        catch(Exception e){
        
        }
    }
    
    public static String printMat(int[][] mat){
        String output = "";
        for(int[] x : mat){
            for(int y : x){
                output += String.format("%-2d", y) + "\t";
            }
            output += "\n";
        }
        return output;
    }
    
    public static int[][] makeSquare(int dimensions){
        int[][] mat = new int[dimensions][dimensions];
        int num = 1, 
            r = 0, 
            c = mat.length/2;
       
        mat[r][c] = num;
        num++;
        
        while(num != dimensions*dimensions + 1){
            r = increment(r, -1, dimensions);
            c = increment(c, 1, dimensions);
            
            if(mat[r][c] != 0){
                r = increment(r, 1, dimensions);
                r = increment(r, 1, dimensions);
                c = increment(c, -1, dimensions);
            }
            mat[r][c] = num;
            num++;
        }
        
        return mat;    
    }
    
    public static int increment(int x, int change, int bounds){
        x += change;
        bounds--;
        if(x > bounds)
            return 0;
        else if(x < 0)
            return bounds;
        return x;
    }
} 