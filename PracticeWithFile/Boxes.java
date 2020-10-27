import java.io.*;
import java.util.Scanner;

public class Boxes
{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("box.dat"));
            PrintWriter printer = new PrintWriter(new FileWriter("box.txt"))){
                int lines = Integer.parseInt(reader.readLine());
                
                for(int i = 0; i < lines; i++){
                    
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
