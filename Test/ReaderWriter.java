import java.io.*;
import java.util.Scanner;

public class ReaderWriter
{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("numbers.dat"));
            PrintWriter writer = new PrintWriter(new FileWriter("sum.dat"))){
            String line;
            
            int sum = 0;
            while((line = reader.readLine()) != null){
                Scanner lyne = new Scanner(line);
                while(lyne.hasNext())
                    sum += lyne.nextInt();
            }
            writer.print(sum);
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        try(BufferedReader reader = new BufferedReader(new FileReader("sum.dat"))){
            String line = reader.readLine();
            System.out.println("the sum is: " + line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
