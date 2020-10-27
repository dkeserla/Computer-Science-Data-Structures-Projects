public class MazeCell 
{
    private int x;
    private int y;
    private boolean isBlank;
    private boolean hasBeen;
    private String show;
    
    public MazeCell(int x, int y, boolean isBlank, boolean hasBeen){
        this.x = x;
        this.y = y;
        this.isBlank = isBlank;
        this.hasBeen = hasBeen;
        this.show = isBlank ? "0": "1";
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean getIsBlank(){
        return isBlank;
    }
    
    public void setHasBeen(boolean hasBeen){
        this.hasBeen = hasBeen;
    }
    
    public boolean getHasBeen(){
        return hasBeen;
    }
    
    public boolean clear(){
        return this.getIsBlank() && !this.getHasBeen();
    }
    
    public void update(){
        setHasBeen(true);
    }
    
    public void resetShow(String x){
        show = x;
    }
    
    public String print(){
        return show;
    }
    
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}