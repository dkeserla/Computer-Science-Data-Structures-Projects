public class BuffetRunner
{
    public static void main(String[] args){
        //person gets set up with random filled stomach
        int stomachFill = (int)(Math.random() * 26) + 10;
        int stomachMax = (int)(Math.random() * 50) + stomachFill;
        Digestive person = new Digestive("Bobby", stomachFill, stomachMax);
        System.out.println(person);
        try{
            while(person.canEat()){
                //person eats between 1 and 10 ounces at a time
                int foodSize = (int)(Math.random() * 10) + 1;
                boolean isSpicy;
                if((int)(Math.random() * 2) == 0)
                    isSpicy = true;
                else
                    isSpicy = false;
                System.out.println("\n"+person.eating(foodSize)); 
                person.eat(foodSize, isSpicy);
                System.out.println(person.getName() + " now has " + person.getCurrentStomach() + " ounces in his stomach");
            }
            
            System.out.println(person.getName() + " will stop eating as they has an exactly full stomach of " + person.getCurrentStomach());
        }
        catch(FullStomachException e){
            System.out.println("OH NO " + person.getName() + " cannot eat more food because his stomach is full, so he stopped eating and food is wasted :(");
        }
        
    }
}
