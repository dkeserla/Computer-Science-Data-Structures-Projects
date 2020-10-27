import java.io.*;
import java.util.Scanner;

public class SS2
{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("social.dat"));
            PrintWriter printer = new PrintWriter(new FileWriter("social.txt"))){
                int lines = Integer.parseInt(reader.readLine());
                int currentSum;
                for(int i = 0; i < lines; i++){
                    String data = reader.readLine();
                    if(data.indexOf("69") > 0){
                        throw new BadInputException("69");
                    }
                    currentSum = 0;
                    Scanner currentLine = new Scanner(data);
                    currentLine.useDelimiter("-");
                    while(currentLine.hasNext())
                        currentSum += currentLine.nextInt();
                    printer.println("SS# " + data +  " has a sum of " + currentSum);
                    printer.println();
                    
                }
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(BadInputException e){
            System.out.println(e);
        }
    }
}
