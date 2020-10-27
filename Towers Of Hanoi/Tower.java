import java.util.Stack;
import java.util.ArrayList;

public class Tower
{
    private Stack<Integer> a;
    private Stack<Integer> b;
    private Stack<Integer> c;
    private int disks;
    private int moves;
    
    public Tower(){
        this(5);
    }
    
    public Tower(int disks){
        this.moves = 0;
        this.disks = disks;
        
        this.a = new Stack<Integer>();
        this.b = new Stack<Integer>();
        this.c = new Stack<Integer>();
        
        for(int i = this.disks; i > 0; i--)
            this.a.push(i);
    } 
    
    public void solve(){
        System.out.println(printTowers());
        solve(disks, a, c, b);
    }
    
    public void solve(int disks, Stack<Integer> start, Stack<Integer> end, Stack<Integer> open){
        if(disks == 1){
            move(start, end);
            return;
        }
        solve(disks - 1, start,  open, end);
        move(start, end);
        solve(disks - 1, open, end, start);
    }
    
    public void move(Stack<Integer> start, Stack<Integer> end){
        moves++;
        end.push(start.pop());
        System.out.println(printTowers());
    }
    
    public String printTowers(){
        String output = "\n";
        
        ArrayList[] lists = new ArrayList[]{new ArrayList<Integer>(this.a), 
                                            new ArrayList<Integer>(this.b), 
                                            new ArrayList<Integer>(this.c)};
                                            
        for(int i = disks - 1; i > -1; i--, output += "\n")
            for(ArrayList x : lists)
                output += printValidIndex(x, i);
        
        output += " a b c\n moves = " + moves;
        return output;
    }
    
    public String printValidIndex(ArrayList<Integer> list, int index){
        return " " + (list.size() > index ? list.get(index) : "*");
    }
}