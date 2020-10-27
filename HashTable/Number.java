//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Number
{
    private int theValue;
    
    public Number(int value)
    {
        theValue = value;
    }   
    
    public int getValue()
    {
        return theValue;
    }
    
    public boolean equals(Object obj)
    {
        return theValue == ((Number)obj).getValue();
    } 
    
    public int hashCode()
    {
        return theValue;
    }

    public String toString()
    {
        return theValue + "";
    }   
}