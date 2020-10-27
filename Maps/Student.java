import java.util.ArrayList;
public class Student
{
    private int gradeLevel;
    private int studentId;
    private ArrayList<String> classes;
    private String lastName;
    
    public Student(){
        this.gradeLevel = 9;
        this.studentId = 666666;
        this.classes = new ArrayList<String>();
        this.lastName = "Smith";
    }
    
    public Student(int gradeLevel, ArrayList<String> classes, String lastName, int studentId){
        this.gradeLevel = gradeLevel;
        this.studentId = studentId;
        this.classes = classes;
        this.lastName = lastName;
    }
    
    public int getGradeLevel(){
        return gradeLevel;
    }
    
    public int getStudentId(){
        return studentId;
    }
    
    public ArrayList<String> getClasses(){
        return gradeLevel;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setGradeLevel(){
        return gradeLevel;
    }
    
    public void setStudentId(){
        return studentId;
    }
    
    public void setClasses(){
        return gradeLevel;
    }
    
    public void setLastName(){
        return lastName;
    }
    
    public String toString(){
        return 
    }
}
