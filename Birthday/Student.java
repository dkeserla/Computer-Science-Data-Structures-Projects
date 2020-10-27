
public class Student{
    private int month;
    private int day;

    public Student(){
        month = (int)(Math.random() * 12) + 1;
        int days;
        switch(month){
            case 2: days = 29; break;
            case 4:
            case 6:
            case 9:
            case 11: days  = 30; break;
            default: days = 31; break;
        }
        day = (int)(Math.random() * days) + 1;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public boolean equals(Student other){
        boolean first = this.getMonth() == other.getMonth();
        boolean second = this.getDay() == other.getDay();
        return first && second;
    }
}
