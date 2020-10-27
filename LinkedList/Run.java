
/**
 * Write a description of class Run here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Run
{
    public static void main(String[] args){
        CustomList listy = new CustomList("apple");
        listy.add("banana");
        listy.add("coconut");
        listy.add("dragonFruit");
        System.out.println("size = " + listy.size() + "  " + listy);
        System.out.println(listy.revToString());
    }
}
