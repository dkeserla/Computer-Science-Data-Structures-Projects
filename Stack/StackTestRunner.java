//A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import static java.lang.System.*;

public class StackTestRunner
{
	public static void main (String[] args)
	{
			StackTester stack = new StackTester("a b c d e f g h i");
			System.out.println(stack + "\n");
			System.out.println("popping all items from the stack");
			stack.popEmAll();
			
// 			stack.setStack("1 2 3 4 5 6 7 8 9 10");
// 			stack.setStack("# $ % ^ ( ) ) _");
	}
}
