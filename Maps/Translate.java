import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
public class Translate
{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("spantoeng.dat"))){
            int lines = Integer.parseInt(reader.readLine());
            Scanner l;
            Map<String,String> words = new HashMap<String,String>();//+20 points
            for(int i = 0; i < lines; i++){
                l = new Scanner(reader.readLine());//+10 points
                words.put(l.next(),l.next());//+40 points
            }
            ArrayList<String> sentences = new ArrayList<String>();
            String line; 
            while((line = reader.readLine()) != null)
                sentences.add(line);
            
            System.out.println("===\tMAP CONTENTS\t===");
            Queue<String> sort = new PriorityQueue<String>(words.keySet());
            System.out.print("{");
            while(!sort.isEmpty()){
                String w = sort.remove();
                if(sort.size()==0)
                    System.out.print(w + "=" + words.get(w) + "}\n");
                else
                    System.out.print(w + "=" + words.get(w) + "\n");
            }
            System.out.println();
            
            for(String x: sentences)
                System.out.println(translate(words,x));
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static String translate(Map<String,String> words, String phrase){
        String out = "";
        Scanner sentence = new Scanner(phrase);
        while(sentence.hasNext())
            out += words.get(sentence.next()) + " ";
        return out;
    }
}
