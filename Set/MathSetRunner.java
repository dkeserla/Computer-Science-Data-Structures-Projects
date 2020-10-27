//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

public class MathSetRunner
{
    public static void main(String args[])
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("mathsetdata.dat"))){
            String line;
            String line2;
            while((line = reader.readLine()) != null && (line2 = reader.readLine()) != null)
                System.out.println("\n"+new MathSet(line, line2));
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
