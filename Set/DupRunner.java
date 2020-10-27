//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
	    String testing1 = "a b c d e f g h a b c d e f g h i j k";
	    String testing2 = "one two three one two three six seven one two";
	    String testing3 = "1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6";
	    
	    System.out.println("Original List : " + testing1);
	    System.out.println("Uniques : " + UniquesDupes.getUniques(testing1));
	    System.out.println("Dupes : " + UniquesDupes.getDupes(testing1));
	    
	    System.out.println("\nOriginal List : " + testing2);
	    System.out.println("Uniques : " + UniquesDupes.getUniques(testing2));
	    System.out.println("Dupes : " + UniquesDupes.getDupes(testing2));
	    
	    System.out.println("\nOriginal List : " + testing3);
	    System.out.println("Uniques : " + UniquesDupes.getUniques(testing3));
	    System.out.println("Dupes : " + UniquesDupes.getDupes(testing3));
	}
}