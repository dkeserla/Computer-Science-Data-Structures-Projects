import java.util.Stack;
import java.util.ArrayList;

public class Maze
{
    private MazeCell[][] maze;
    private Stack<MazeCell> breadCrum;
    private MazeCell currentPosition;
    private MazeCell end;
    
    public Maze(int[][] nums)
    {
        maze = new MazeCell[nums.length][nums[0].length];
        breadCrum = new Stack<MazeCell>();
        for(int r = 0; r < nums.length; r++)
            for(int c = 0; c < nums[r].length; c++)
                maze[r][c] = new MazeCell(r, c, nums[r][c] == 0 ? true : false, false);
        currentPosition = maze[0][0];
        currentPosition.landed();
        breadCrum.push(currentPosition);
        end = maze[maze.length-1][maze[0].length-1];
    }
    
    public MazeCell[][] getMaze(){
        return maze;
    }
    
    public Stack<MazeCell> getBreadCrums(){
        return breadCrum;
    }

    public void solve(){
        while(!end.getHasBeen()){
            currentPosition = breadCrum.peek();
            if(leftClear(currentPosition)) 
                setPosition(0, 1);
            else if(rightClear(currentPosition)) 
                setPosition(0, -1);
            else if(upClear(currentPosition)) 
                setPosition(-1, 0);
            else if(downClear(currentPosition)) 
                setPosition(1, 0);
            else
                breadCrum.pop();
        }
    }
    
    public void setPosition(int r, int c){
        currentPosition = maze[currentPosition.getX() + r][currentPosition.getY() + c];
        breadCrum.push(currentPosition);
        currentPosition.landed();
    }
    
    public boolean isClear(int r, int c){
        return currentPosition.getY() < maze[0].length-1 && currentPosition.getY() > 0 && currentPosition.getX() > 0 &&  currentPosition.getX() < maze.length-1 && maze[currentPosition.getX()+r][currentPosition.getY()+c].clear();
    }
    
    public boolean leftClear(MazeCell m){
        return m.getY() < maze[0].length-1 && maze[m.getX()][m.getY()+1].clear();
    }
    
    public boolean rightClear(MazeCell m){
        return m.getY() > 0 && maze[m.getX()][m.getY()-1].clear();
    }
    
    public boolean upClear(MazeCell m){
        return m.getX() > 0 && maze[m.getX()-1][m.getY()].clear();
    }
    
    public boolean downClear(MazeCell m){
        return m.getX() < maze.length-1 && maze[m.getX()+1][m.getY()].clear();
    }
    
    public String print(){
        String output = "";
        ArrayList<MazeCell> coords = new ArrayList<MazeCell>();
        while(!breadCrum.isEmpty())
            coords.add(0,breadCrum.pop());
        for(int i = 0; i < coords.size(); i++)
            output += coords.get(i) + "\n";
        return output;
    }
}
