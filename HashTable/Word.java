//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class Word
{
    private String theValue;
    
    //write a constructor method
    public Word(String x){
        theValue = x;
    }
    
    //write the getValue method
    public String getValue(){
        return theValue;
    }
    
    //write the equals method
    public boolean equals(Object obj){
        return theValue.equals(((Word)obj).getValue());
    }
    
    //write the hashCode method
    public int hashCode(){
        int vowels = 0;
        for(int i = 0; i < theValue.length(); i++)
            if("aeiou".contains(theValue.substring(i,i+1)))
                vowels++;
        return (vowels * theValue.length()) % 10;
    }
    
    //write the toString method
    public String toString(){
        return theValue.toString();
    }
    
    
}