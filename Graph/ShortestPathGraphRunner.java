import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.ArrayList;
public class ShortestPathGraphRunner
{
    public static void main( String[] args ) 
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("cities.dat"))){
            String line;
            ShortestClassGraph graph = new ShortestClassGraph();
//             ShortestPathGraph graph = new ShortestPathGraph();
            while((line = reader.readLine()) != null)
                graph.putInMap(line);       
                
            graph.check("Austin", "Seattle", "miles");
            System.out.println(graph);
            graph.check("Austin", "Seattle", "time");
            System.out.println(graph);
            graph.check("Austin", "Seattle", "tolls");
            System.out.println(graph);
        }
        catch(IOException e){
            System.out.println("YOU GOOSE");
        }
    }
}