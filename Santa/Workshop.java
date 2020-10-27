import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collection;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.Comparator;
public class Workshop
{
    public static void main(String[] args){
        String[] out = {"1 - print list children", "2 - record nice", "3 - record naughty", "4 - update nice naughty state", "5 - print santa route", "6 - exit"};
        Scanner input = new Scanner(System.in);
        ArrayList<Child> children = makeChildren();
        Map<Child, Stack<String>> presents = new HashMap<Child, Stack<String>>();
        Map<Child, ArrayList<String>> niceList = new HashMap<Child, ArrayList<String>>();
        Map<Child, ArrayList<String>> naughtyList = new HashMap<Child, ArrayList<String>>();
        for(Child x : children){
            presents.put(x, new Stack<String>());
            niceList.put(x, new ArrayList<String>());
            naughtyList.put(x, new ArrayList<String>());
        }
        Comparator<Child> compare = (Child x, Child y) -> {
            if(x.getNiceLevel() > y.getNiceLevel())
                return -1;
            else if(x.getNiceLevel() < y.getNiceLevel())
                return 1;
            else{
                if(presents.get(x).size() > presents.get(y).size())
                    return -1;
                else if (presents.get(x).size() < presents.get(y).size())
                    return 1;
                return 0;
            }
        };
        boolean game = true;
        while(game){
            for(String x : out)
                System.out.println(x);
            System.out.print("\nenter your choice: ");
            int data = input.nextInt();
            Child x;
            switch(data){
                case 1: System.out.println(printChildren(children)); 
                        break;
                        
                case 2: System.out.println(printChildren(children));
                        System.out.print("\nwhich kid did something nice: ");
                        x = children.get(input.nextInt());
                        System.out.print("\nwhat did " + x.getName() + " do?: ");
                        niceList.get(x).add(input.next()  + input.nextLine());
                        System.out.println();
                        x.setNiceLevel(niceList.get(x).size() - naughtyList.get(x).size());
                        System.out.println(niceONaughty(children, niceList, naughtyList)); 
                        break;
                        
                case 3: System.out.println(printChildren(children)); 
                        System.out.print("\nwhich kid did something naughty: ");
                        x = children.get(input.nextInt());
                        System.out.print("\nwhat did " + x.getName() + " do?: ");
                        naughtyList.get(x).add(input.next() + input.nextLine());
                        System.out.println();
                        x.setNiceLevel(niceList.get(x).size() - naughtyList.get(x).size());
                        System.out.println(niceONaughty(children, niceList, naughtyList));
                        break;
                        
                case 4: System.out.println(updateNiceONaughty(children, niceList, naughtyList, presents)); 
                        break;
                        
                case 5: System.out.println(printPriority(children, compare, presents)); 
                        break;
                        
                case 6: game = false; 
                        break;
            }
        }
        System.out.println("Ho Ho Ho! Merry Christmas!");
    }
    
    public static ArrayList<Child> makeChildren(){
        ArrayList<Child> children = new ArrayList<Child>();
        String[] names = {"Stewie", "Peter", "Brian", "Meg", "Lois", "Chris", "Quagmire", "Joe", "Cleveland", "Bonnie"};
        Integer[] ages = {7, 45, 7, 18, 42, 16, 54, 52, 43, 48};
        String[] addresses = {"43 E. San Pablo Circle South Plainfield, NJ 07080", "95 Augusta Ave. Arlington Heights, IL 60004", "8659 Bear Hill Drive Selden, NY 11784", "75 Forest Court Plainfield, NJ 07060", "4 N. Bald Hill Drive Dover, NH 03820", "126 Primrose Drive Grayslake, IL 60030","77 Arnold St. Kingsport, TN 37660","7244 Saxon St. Mooresville, NC 28115","9859 N. Old York Ave. Little Falls, NJ 07424","78 Lake Rd. Oceanside, NY 11572"};
            
        for(int i = 0; i < 10; i++)
            children.add(new Child(names[i], ages[i], 0, addresses[i]));
        return children;
    }
    
    public static String printChildren(ArrayList<Child> children){
        String output = "";
        int i = 0;
        for(Child x : children){
            output += i + " " + x.toString() + "\n";
            i++;
        }
        return output;
    }
    
    public static String niceONaughty(ArrayList<Child> children, Map<Child, ArrayList<String>> niceList, Map<Child, ArrayList<String>> naughtyList){
        String output = "";
        output += "\nNICELIST\n";
        for(Child x : children)
            output += x.getName() + " " + niceList.get(x) + "\n";
        output += "\nNAUGHTYLIST\n";
        for(Child x : children)
            output += x.getName() + " " + naughtyList.get(x) + "\n";
        return output;
    }
    
    public static String updateNiceONaughty(ArrayList<Child> children, Map<Child, ArrayList<String>> niceList, Map<Child, ArrayList<String>> naughtyList, Map<Child, Stack<String>> presents){
        String output = "\n" + printChildren(children) + "\n\nList Of Presents\n";
        
        for(Child x : children){
            Stack<String> present = presents.get(x);
            if(x.getNiceLevel() > 0)
                if(present.isEmpty() || present.peek().equals("toy"))
                    present.push("toy");
                else
                    present.pop();
            else
                if(present.isEmpty() || present.peek().equals("coal"))
                    present.push("coal");
                else
                    present.pop();
                    
            output += x.getName() + " " + present + "\n";
        }
        
        output += "\n\n" + printChildren(children);
        return output;
    }
    
    public static String printPriority(ArrayList<Child> childs, Comparator<Child> compare, Map<Child, Stack<String>> presents){
        PriorityQueue<Child> children = new PriorityQueue(compare);
        for(Child x : childs)
            children.add(x);
        String output = "";
        while(!children.isEmpty()){
            Child x = children.remove();
            output += x.getName() + " at " + x.getAddress() +  ", will get " + presents.get(x).size() + " " + (presents.get(x).isEmpty() || !presents.get(x).peek().contains("coal") ? "present(s)" : "lump(s) of coal") + "\n";
        }
        return output;
    }
    
}