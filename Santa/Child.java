public class Child
{
    private String name;
    private int age;
    private int niceLevel;
    private String address;
    
    public Child(String name, int age, int niceLevel, String address){
        this.name = name;
        this.age = age;
        this.niceLevel = niceLevel;
        this.address = address;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public int getNiceLevel(){
        return niceLevel;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setNiceLevel(int niceLevel){
        this.niceLevel = niceLevel;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String toString(){
        return String.format("%s(%d years old) is nice level = %d, %s", name, age, niceLevel, address);
    }
}