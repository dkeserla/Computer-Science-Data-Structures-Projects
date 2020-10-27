//A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
    private Set<Integer> odds;
    private Set<Integer> evens;

    public OddEvenSets()
    {
        odds = new TreeSet<Integer>();
        evens = new TreeSet<Integer>();
    }

    public OddEvenSets(String line)
    {
        odds = new TreeSet<Integer>();
        evens = new TreeSet<Integer>();
        Scanner nums = new Scanner(line);
        while(nums.hasNext()){
            int currentNum = nums.nextInt();
            if((currentNum & 1)==1)
               odds.add(currentNum);
            else
               evens.add(currentNum);
            }
    }

    public String toString()
    {
        return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
    }
}