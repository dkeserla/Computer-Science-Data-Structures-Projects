import java.io.*;
public class BadInputException extends Exception
{
    public BadInputException(String name)
    {
        super(name + " is a bad boy");
    }
}
