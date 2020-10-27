 //� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class PostFix
{
    private Stack<Double> stack;
    private String expression;

    public PostFix()
    {
        setExpression("");
    }

    public PostFix(String exp)
    {
        setExpression(exp);
    }

    public void setExpression(String exp)
    {
        expression = exp;
        stack = new Stack<Double>();
        Scanner text = new Scanner(expression);
        while(text.hasNext()){
            String x = text.next();
            if("+-*/".indexOf(x) == -1)
                stack.push((double)Integer.parseInt(x));
            else
                stack.push(calc(stack.pop(),stack.pop(),x.charAt(0)));
        }
    }

    public double calc(double one, double two, char op)
    {
        double result = 0;
        switch(op){
            case '+': result = two + one; break;
            case '-': result = two - one; break;
            case '*': result = two * one; break;
            case '/': result = two / one; break;
        }
        return result;
    }

    public String toString(){
        return expression + " = " + stack.pop();
    }
}