public class Digestive{
    private int currentStomach;
    private int stomachSize;
    private String name;
    
    public Digestive(String name, int currentStomach, int stomachSize){
        this.name = name;
        this.currentStomach = currentStomach;
        this.stomachSize = stomachSize;
    }

    public void eat(int ounces, boolean spicy) throws FullStomachException{
        if(currentStomach + ounces > stomachSize){
            throw new FullStomachException();
        }
        currentStomach += ounces;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCurrentStomach(){
        return currentStomach;
    }
    
    public int getStomachSize(){
        return stomachSize;
    }
    
    public boolean canEat(){
        return this.getCurrentStomach() < this.getStomachSize();
    }
    
    public String eating(int foodSize){
        return this.getName() + " is going to eat " + foodSize + " ounces of food on this trip";
    }
    
    public String toString(){
        return name + " has a stomach that has a max capacity of " + stomachSize + ", and their current stomach is already filled with " + currentStomach + " ounces";
    }
}
