public class Runner
{
    public static void main(String[] args){
        String boy1 = "Dinesh";
        String boy2 = "Mauricio";
        try{
           System.out.println(checkName(boy1));
           System.out.println(checkName(boy2));
        }
        catch(BadInputException e)
        {
            System.out.println(e);
        }
    }
    
    public static String checkName(String name) throws BadInputException{
        if(name.equals("Mauricio")){
            throw new BadInputException(name);
        }
        return name + " You're Good";
    }
}
