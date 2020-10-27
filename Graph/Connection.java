public class Connection
{
    private String from;
    private String to;
    private int miles;
    private int times;
    private int tolls;
    
    public Connection(String from, String to, int miles, int times, int tolls){
        this.from = from;
        this.to = to;
        this.miles = miles;
        this.times = times;
        this.tolls = tolls;
    }
    
    public String getFrom(){
        return from;
    }
    
    public String getTo(){
        return to;
    }
    
    public int getMiles(){
        return miles;
    }
    
    public int getTimes(){
        return times;
    }
    
    public int getTolls(){
        return tolls;
    }
    
    public String toString(){
        return from + " " + to + " " + miles + " " + times + " " + tolls;
    }
}
