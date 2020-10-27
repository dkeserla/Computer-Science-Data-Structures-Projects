//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTable
{
    private LinkedList[] table;

    public HashTable()
    {
        table = new LinkedList[10];
        for(int i = 0; i < table.length; i++)
            table[i] = new LinkedList();
    }

    public void add(Object obj)
    {
        int i = obj.hashCode();
        i %= 10;
        LinkedList spot = table[i];
        //Number x = (Number)obj;
        Word x = (Word)obj;
        if(!spot.contains(x))
            spot.add(x);
    }

    public String toString()
    {
        String output="HASHTABLE";
        
        for(int i = 0; i < table.length; i++){
            output += "\nbucket " + i + " ";
            for(Object x : table[i])
                output += x + " ";
        }

        return output;
    }
}