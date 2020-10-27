import java.util.Scanner;

public class Birthday
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("how many students are in the class? ");
        int students = input.nextInt();
        
        System.out.print("how many trials do you want to run? ");
        int trials = input.nextInt();
        
        System.out.print("do you want to see all the matching trials(Y or N)? ");
        boolean doTrials;
        if(input.next().equals("Y"))
            doTrials = true;
        else
            doTrials = false;
        
        System.out.println(String.format("the theoretical probability of a match is: %.4f",getTheoretical(students)));
        
        for(int i = 0; i < trials; i++)
            trail(students);
        
    }
    
    public static double getTheoretical(int students){
        return 1 - Math.pow((364.0/365.0), (students*(students-1)/2.0));
    }
    
    public static String trial(int student){
        Student[] studentArray = new Student[students];
        for(int i = 0; i < studentArray; i++)
            studentArray[i] = new Student();
        return "";
    }
}
