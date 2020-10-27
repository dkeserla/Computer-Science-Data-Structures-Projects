//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
        try(BufferedReader reader = new BufferedReader(new FileReader("words.dat"))){
            //make a new table          
            HashTable table = new HashTable();
            //read from the file    
            int lines = Integer.parseInt(reader.readLine());
            for(int i = 0; i < lines; i++){
                Scanner line = new Scanner(reader.readLine());
                //load stuff into the table
                //table.add(new Number(line.nextInt()));
                table.add(new Word(line.next()));
            }
            //print out the table
            System.out.println(table);
        }
        catch(Exception e)
        {
            System.out.println("Houston, we have a problem!");
        }
  }
}