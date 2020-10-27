import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.PriorityQueue;

public class Relative
{
    public static void main(String[] args){
        
        Map<String,ArrayList<String>> relatives = new HashMap<String,ArrayList<String>>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader("relatives.dat"))){
            int lines = Integer.parseInt(reader.readLine());
            Scanner line;
            for(int i = 0; i < lines; i++){
                line = new Scanner(reader.readLine());
                String key = line.next();
                String value = line.next();
                
                if(relatives.containsKey(key))
                    relatives.get(key).add(value);
                else{
                    ArrayList<String> values = new ArrayList<String>();
                    values.add(value);
                    relatives.put(key,values);
                }
            }
            
            Queue<String> sorted = new PriorityQueue<String>();
            for(String key : relatives.keySet())
                sorted.add(key);
            
            while(!sorted.isEmpty()){
                String key = sorted.remove();
                Queue<String> sortedVal = new PriorityQueue<String>(relatives.get(key));
                System.out.print(key + " is related to ");
                while(!sortedVal.isEmpty())
                    System.out.print(sortedVal.remove() + " ");
                System.out.println();
            }
        }
        catch(IOException e)
        {
        }
        
        
    }
}
