import java.util.Scanner;
import java.util.Arrays;
public class Yahtzee
{
    public static void main(String[] args){
        YahtzeeCalculations game = new YahtzeeCalculations();
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 13; i++){
            String choice = "r";
            int rolls = 1;
            System.out.println(game);
            game.roll();
            System.out.println("You rolled " + Arrays.toString(game.getRoll()));
            System.out.print("Reroll<r> or Score<s>: ");
            choice = in.next();
            while(!choice.equals("r") && !choice.equals("s")){
                System.out.print("\nchoose a valid option: ");
                choice = in.next();
            }
            while(choice.equals("r")){
                System.out.print("reroll what? : ");
                String indexes = in.next() + in.nextLine();
                game.roll(indexes.split(" "));
                System.out.println("You rolled " + Arrays.toString(game.getRoll()));
                if(rolls == 2)
                    break;
                System.out.print("Reroll<r> or Score<s>: ");
                choice = in.next();
                while(!choice.equals("r") && !choice.equals("s")){
                    System.out.print("\nchoose a valid option: ");
                    choice = in.next();
                }
                rolls++;
            }
            
            boolean reScore = false;
            while(!reScore){
                System.out.println("\nones<1>, twos<2>, threes<3>, fours<4>, fives<5>, sixes<6>, 3kind<3k>, 4kind<4k>, full<f>, sStraight<sS>, lStraight<lS>, yahtzee<y>, chance<c>");
                System.out.print("How do you want to score: ");
                String score = in.next();
                System.out.println();
                switch(score){
                    case "1": reScore = game.updateScoreCard(0, game.calculateUpper(1));break;
                    case "2": reScore = game.updateScoreCard(1, game.calculateUpper(2)); break;
                    case "3": reScore = game.updateScoreCard(2, game.calculateUpper(3)); break;
                    case "4": reScore = game.updateScoreCard(3, game.calculateUpper(4)); break;
                    case "5": reScore = game.updateScoreCard(4, game.calculateUpper(5)); break;
                    case "6": reScore = game.updateScoreCard(5, game.calculateUpper(6)); break;
                    case "3k": reScore = game.updateScoreCard(8, game.calculate3Kind()); break;
                    case "4k": reScore = game.updateScoreCard(9, game.calculate4Kind()); break;
                    case "f": reScore = game.updateScoreCard(10, game.calculateFullHouse()); break;
                    case "sS": reScore = game.updateScoreCard(11, game.calculateSmallStraight()); break;
                    case "lS": reScore = game.updateScoreCard(12, game.calculateLargeStraight()); break;
                    case "y": reScore = game.updateScoreCard(13, game.calculateYahtzee()); break;
                    case "c": reScore = game.updateScoreCard(14, game.calculateChance()); break;
                }
            } 
        }
        System.out.println(game);
        System.out.println("Your final score was " + game.getGrandTotal());
    }
}
