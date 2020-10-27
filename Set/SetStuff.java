import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeSet;

public class SetStuff
{
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(3,2,5,1,4));
        System.out.println("ArrayList = " + nums);
        
        Set<Integer> numSet = new HashSet<Integer>(nums);
        System.out.println("HashSet = " + numSet);
        Set<Integer> numSet2 = new TreeSet<Integer>(nums);
        System.out.println("TreeSet = " +numSet2);

        nums = new ArrayList<Integer>(numSet2);
        System.out.println("ArrayList = " + nums);
        
        Stack<Integer> numStack = new Stack<Integer>();
        numStack.addAll(nums);
        System.out.println("Stack = " + numStack);
        System.out.println("First Popped off of Stack is " + numStack.pop());
        
        Queue<Integer> linkedNums = new LinkedList<Integer>(nums);
        System.out.println("Queue = " + linkedNums);
        System.out.println("First Removed of Queue is " + linkedNums.remove());
    }
}
