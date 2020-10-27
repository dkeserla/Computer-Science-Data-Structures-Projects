//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -  

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.Scanner;

public class MathSet
{
    private Set<Integer> one;
    private Set<Integer> two;

    public MathSet()
    {
        this("","");
    }

    public MathSet(String o, String t)
    {
        one = new TreeSet<Integer>();
        two = new TreeSet<Integer>();
        
        Scanner nums = new Scanner(o);
        while(nums.hasNext())
            one.add(nums.nextInt());
        
        nums = new Scanner(t);    
        while(nums.hasNext())
            two.add(nums.nextInt());
    }

    public Set<Integer> union()
    {
        Set<Integer> union = new TreeSet<Integer>();
        
        for(Integer x : one)
            union.add(x);
            
        for(Integer x : two)
            union.add(x);
        return union;
    }

    public Set<Integer> intersection()
    {
        Set<Integer> union = new TreeSet<Integer>();
        Set<Integer> intersection = new TreeSet<Integer>();
        
        for(Integer x : one)
            if(!union.add(x))
                intersection.add(x);
            
        for(Integer x : two)
            if(!union.add(x))
                intersection.add(x);
        
        return intersection;
    }
    
    public Set<Integer> difference(Set<Integer> a, Set<Integer> b){
        Set<Integer> difference = new TreeSet<Integer>();
        
        for(Integer x : a)
            if(!b.contains(x))
                difference.add(x);
        
        return difference;
    }

    public Set<Integer> differenceAMinusB()
    {
        return difference(one,two);
    }

    public Set<Integer> differenceBMinusA()
    {
        return difference(two,one);
    }
	
    public Set<Integer> symmetricDifference()
    {		
    	return difference(union(), intersection());
    }	
	
    public String toString()
    {
    	return "Set one " + one + "\n" +	"Set two " + two +  "\n" + operations();
    }
    
    public String operations(){
        return "\nunion - " + union() + "\nintersection - " + intersection() + "\ndifference A-B - " + differenceAMinusB() + "\ndifference B-A - " + differenceBMinusA() + "\nsymmetric difference " + symmetricDifference() + "\n";
    }
}