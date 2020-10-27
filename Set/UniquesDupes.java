// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes
{
    public static Set<String> getUniques(String input)
    {
        String[] words = input.split(" ");
        Set<String> uniques = new TreeSet<String>();

        for(String x: words)
            uniques.add(x);

        return uniques;
    }

    public static Set<String> getDupes(String input)
    {
        String[] words = input.split(" ");
        Set<String> uniques = new TreeSet<String>();
        Set<String> dupes = new TreeSet<String>();
        
        for(String x: words)
            if(!uniques.add(x))
               dupes.add(x);
        
        
        return dupes;
    }
}