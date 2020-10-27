import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

public class Tester
{
    public static void main(String[] args){
        Maze maze;
        try(BufferedReader reader = new BufferedReader(new FileReader("basicMaze.dat"))){
            Scanner scan = new Scanner(reader.readLine());
            int[][] numMaze = new int[scan.nextInt()][scan.nextInt()];
            for(int r = 0; r < numMaze.length; r++){
                scan = new Scanner(reader.readLine());
                for(int c = 0; c < numMaze.length; c++){
                    numMaze[r][c] = scan.nextInt();
                }
            }
            maze = new Maze(numMaze);
            maze.solve();
            System.out.println(maze.print());
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}