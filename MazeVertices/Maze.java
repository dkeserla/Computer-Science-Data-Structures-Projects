import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;

public class Maze 
{
    private MazeCell[][] maze;
    private Stack<MazeCell> breadCrum;
    private MazeCell currentPosition;
    private MazeCell end;
    private HashMap<MazeCell, ArrayList<MazeCell>> graph;
    private ArrayList<MazeCell> shortestPath;
    private int shortest;
    public Maze(int[][] nums)
    {
        maze = new MazeCell[nums.length][nums[0].length];
        breadCrum = new Stack<MazeCell>();
        for(int r = 0; r < nums.length; r++)
            for(int c = 0; c < nums[r].length; c++)
                maze[r][c] = new MazeCell(r, c, nums[r][c] == 0, false);
        currentPosition = maze[0][0];
        currentPosition.update();
        breadCrum.push(currentPosition);
        end = maze[maze.length-1][maze[0].length-1];
        graph = new HashMap<MazeCell, ArrayList<MazeCell>>();
        shortestPath = new ArrayList<MazeCell>();
        shortest = Integer.MAX_VALUE;
        
        for(int r = 0; r < maze.length; r++)
            for(int c = 0; c < maze[r].length; c++)
                putCellEdges(r,c);
             
    }
    
    
    public void putCellEdges(int r, int c){
        MazeCell m = maze[r][c];
        if(!m.getIsBlank())
            return;
         
        ArrayList<MazeCell> edges = new ArrayList<MazeCell>();
        if(leftClear(m)) 
            edges.add(maze[r][c+1]);
        if(rightClear(m)) 
            edges.add(maze[r][c-1]);
        if(upClear(m)) 
            edges.add(maze[r-1][c]);
        if(downClear(m)) 
            edges.add(maze[r+1][c]);
        
        graph.put(m, edges);    
    }
    
    public void check(){
        check(currentPosition, end, new ArrayList<MazeCell>(), 0);
        for(MazeCell m : shortestPath)
            m.resetShow("-");
    }
    
    public void check(MazeCell a, MazeCell b, ArrayList<MazeCell> places, int cost){
        if(cost > shortest)
            return;
        places.add(a);
        if(a == b){
            if(cost < shortest){
                shortestPath = new ArrayList<MazeCell>(places);
                shortest = cost;
            }
        }
        else
            for(MazeCell e : graph.get(a))
                if(!places.contains(e))
                    check(e, b, new ArrayList<MazeCell>(places), cost+1);
    }
    
    public MazeCell[][] getMaze(){
        return maze;
    }
    
    public String getShortestPath(){
        String path = "";
        for(int i = 0; i < shortestPath.size(); i++){
            if(i%5==0)
                path += "\n";
            path += String.format("%-10s ", shortestPath.get(i).toString());
        }
        return path;
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
    
    public String toString(){
        String out = "";
        for(int r = 0; r < maze.length; r++, out += "\n")
            for(int c = 0; c < maze[r].length; c++)
                out += maze[r][c].print() + " ";
        return out;
    }
}