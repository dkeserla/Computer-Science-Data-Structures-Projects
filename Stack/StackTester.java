//A+ Computer Science  -  www.apluscompsci.com
//Name -  
//Date -
//Class -
//Lab  -

import java.util.Stack;
import static java.lang.System.*;
import java.util.Scanner;

public class StackTester
{
    private Stack<String> stack;

    public StackTester()
    {
        setStack("");
    }

    public StackTester(String line)
    {   
        setStack(line);
    }
    
    public void setStack(String line)
    {
        Scanner let = new Scanner(line);
        while(let.hasNext()){
            stack.push(let.next());
        }
    }

    public void popEmAll()
    {
        while(!stack.isEmpty())
            stack.pop();
    }

    public String toString(){
        return stack.toString();
    }
}