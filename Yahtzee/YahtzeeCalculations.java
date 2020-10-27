

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class YahtzeeCalculations
{
    
    private int[] roll;
    private HashMap<Integer, Integer> count;
    private int[] scoreCard;
    private int grandTotal;
    
    public YahtzeeCalculations(){
        roll = new int[5];
        count = new HashMap<Integer, Integer>();
        scoreCard = new int[16];
        for(int i = 0; i < scoreCard.length; i++)
            scoreCard[i] = -1;
        grandTotal = 0;
    }
    
    public int[] getRoll(){
        return roll;
    }
    
    public HashMap<Integer, Integer> getCount(){
        return count;
    }
    
    public int[] getScoreCard(){
        return scoreCard;
    }
    
    public void setRoll(int[] x){
        roll = x;
    }
    
    public boolean updateScoreCard(int index, int input){
        if(scoreCard[index] == -1){
            scoreCard[index] = input;
            return true;
        }
        return false;
    }
    
    public void resetCount(){
        count = new HashMap<Integer, Integer>();
        for(int i = 0; i < roll.length; i++)
            if(count.containsKey(roll[i]))
                count.put(roll[i], count.get(roll[i])+1);
            else
                count.put(roll[i],1);
    }
    
    public void roll(){
        count = new HashMap<Integer, Integer>();
        for(int i = 0; i < roll.length; i++){
            roll[i] = (int)(Math.random() * 6) + 1;
            if(count.containsKey(roll[i]))
                count.put(roll[i], count.get(roll[i])+1);
            else
                count.put(roll[i],1);
        }
    }
    
    public void roll(String[] indexes){
        count = new HashMap<Integer, Integer>();
        for(int i = 0; i < indexes.length; i++)
            roll[Integer.parseInt(indexes[i])] = (int)(Math.random() * 6) + 1;
        resetCount();
    }
    
    public int rollSum(){
        int sum = 0;
        for(int x : roll)
            sum += x;
        return sum;
    }
    
    public int calculateUpper(int num){
        if(count.containsKey(num))
            return count.get(num) * num;
        return 0;
    }
    
    public int calculate3Kind(){
        for(int x: count.values())
            if(x >= 3)
                return rollSum();
        return 0;
    }
    
    public int calculate4Kind(){
        for(int x: count.values())
            if(x >= 4)
                return rollSum();
        return 0;
    }
    
    public int calculateFullHouse(){
        ArrayList<Integer> count = new ArrayList<Integer>(this.count.values());
        if(count.size() <= 2 && (count.get(0) != 4 || count.get(0) != 1))
            return 25;
        return 0;
    }
    
    public int calculateSmallStraight(){
        int sequential = 0;
        ArrayList<Integer> keys = new ArrayList<Integer>(this.count.keySet());
        for(int i = keys.size()-1; i > 0; i--)
            if(keys.get(i) - keys.get(i-1) == 1)
                sequential++;
        return sequential >= 3 ? 30: 0;
    }
    
    public int calculateLargeStraight(){
        int sequential = 0;
        ArrayList<Integer> keys = new ArrayList<Integer>(this.count.keySet());
        for(int i = keys.size()-1; i > 0; i--)
            if(keys.get(i) - keys.get(i-1) == 1)
                sequential++;
        return sequential >= 4 ? 40: 0;
    }
    
    public int calculateYahtzee(){
        return this.count.values().contains(5) ? 50 : 0;
    }
    
    public int calculateChance(){
        return rollSum();
    }
    
    public int topSum(){
        int upper = 0;
        for(int i = 0; i < 6; i++)
            upper += scoreCard[i] != -1? scoreCard[i] : 0;    
        return upper;
    }
    
    public int totalBottom(){
        int bottom = 0;
        for(int i = 8; i < scoreCard.length-1; i++)
            bottom += scoreCard[i] != -1? scoreCard[i] : 0;
        return bottom;
    }
    
    public int getGrandTotal(){
        return grandTotal;
    }
    
    public void updateTotals(){
        int totalUpper = topSum();
        scoreCard[6] = totalUpper >= 63? 35: 0;
        scoreCard[7] = scoreCard[6] + totalUpper < 0? 0: scoreCard[6] + totalUpper;
        
        scoreCard[15] = totalBottom();
        
        grandTotal = scoreCard[7] + scoreCard[15];
    }
    
    public String toString(){
        updateTotals();
        String out = "";
        String[] text = {"ones", "twos", "threes", "fours", "fives", "sixes", "bonus", "total upper", "3 of a kind", "4 of a kind", "full house", "small straight", "large straight", "yahtzee", "chance", "total bottom"}; 
        for(int i = 0; i < scoreCard.length; i++){
            out += text[i] + " = " + (scoreCard[i]==-1? " ": scoreCard[i]) + "\n";
            if(i == 7)
                out+= "\n";
        }
        out+= "\ngrand total = " + (grandTotal != -1? grandTotal: " "); 
        return out+"\n";
    }
}
