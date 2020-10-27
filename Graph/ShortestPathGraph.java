import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.ArrayList;
public class ShortestPathGraph
{
    private TreeMap<String, ArrayList<String>> map;
    private int shortest;
    private String connection;
    private ArrayList<String> path;
    
    public ShortestPathGraph()
    {
       map = new TreeMap<String, ArrayList<String>>();
       shortest = Integer.MAX_VALUE;
       connection = "";
       path  = new ArrayList<String>();
    }
    
    public void putInMap(String l){
        Scanner line = new Scanner(l);
        String a = line.next();
        String b = line.next();
        int m = line.nextInt();
        int ti = line.nextInt();
        int to = line.nextInt();
        String one = b + " " + m + " " + ti + " " + to;
        if(!map.containsKey(a)){
            ArrayList<String> x = new ArrayList<String>();
            x.add(one);
            map.put(a,x);
        }
        else
          map.get(a).add(one);
          
        String two = a + " " + m + " " + ti + " " + to;
        if(!map.containsKey(b)){
            ArrayList<String> x = new ArrayList<String>();
            x.add(two);
            map.put(b,x);
        }
        else
          map.get(b).add(two);
    }
    
    public void check(String a, String b, String comp)
    {
        this.check(a, b, new ArrayList<String>(), 0, comp);
        connection = String.format("%s connects to %s == %s ", a, b, shortest != Integer.MAX_VALUE ? String.format("yes in %d steps", shortest) : "no");
    }

    public void check(String first, String second, ArrayList<String> placesUsed, int steps, String comp)
    {
        placesUsed.add(first);
        if(first.equals(second)){
            if(steps < shortest){
                shortest = steps;
                path = placesUsed; 
            }
        }
        else{
            ArrayList<String> connections = map.get(first);
            for(String con : connections){
                String[] spots = con.split(" ");
                int add = 0;
                if(comp.equals("miles"))
                    add = Integer.parseInt(spots[1]);
                else if(comp.equals("time"))
                    add = Integer.parseInt(spots[2]);
                else
                    add = Integer.parseInt(spots[3]);
                    
                if(!placesUsed.contains(spots[0]))
                    check(spots[0], second, new ArrayList<String>(placesUsed), steps + add, comp);
            }
        }
    }

    public String toString()
    {
        return connection + "\n" + path.toString();
    }
}
