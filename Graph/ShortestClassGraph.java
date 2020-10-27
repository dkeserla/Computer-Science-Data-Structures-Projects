import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.ArrayList;
public class ShortestClassGraph
{
    private HashMap<String, ArrayList<Connection>> map;
    private int shortest;
    private String connection;
    private ArrayList<String> path;
    
    public ShortestClassGraph()
    {
       map = new HashMap<String, ArrayList<Connection>>();
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
        
        if(!map.containsKey(a)){
            ArrayList<Connection> x = new ArrayList<Connection>();
            x.add(new Connection(a,b,m,ti,to));
            map.put(a,x);
        }
        else
          map.get(a).add(new Connection(a,b,m,ti,to));
          
        if(!map.containsKey(b)){
            ArrayList<Connection> x = new ArrayList<Connection>();
            x.add(new Connection(b,a,m,ti,to));
            map.put(b,x);
        }
        else
          map.get(b).add(new Connection(b,a,m,ti,to));
    }

    public String getMap(){
        return map.toString();
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
            ArrayList<Connection> connections = map.get(first);
            for(Connection con : connections){
                int add = 0;
                if(comp.equals("miles"))
                    add = con.getMiles();
                else if(comp.equals("time"))
                    add = con.getTimes();
                else if(comp.equals("tolls"))
                    add = con.getTolls();
                    
                if(!placesUsed.contains(con.getTo()))
                    check(con.getTo(), second, new ArrayList<String>(placesUsed), steps + add, comp);
            }
        }
    }

    public String toString()
    {
        return connection + "\n" + path.toString();
    }
}
