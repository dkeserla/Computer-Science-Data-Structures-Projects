import java.io.*;
import java.util.Scanner;

public class Input
{
    public static void main(String[] args){
        try(PrintWriter printer = new PrintWriter(new FileWriter("out.txt"))){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter in 5 words");
            for(int i = 0; i < 5; i++){
                System.out.print("\nword " + (i+1) + ": ");
                printer.println(keyboard.next());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
