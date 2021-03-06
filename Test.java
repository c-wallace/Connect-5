import java.util.*;
import java.io.*;
/**
 * Created by claire on 9/30/16.
 */
public class Test
{
    public static void main(String args[]) throws IOException
    {
        try
        {
            int numHumans;
            int boardSize;
            int turns = 0;
            LookingClass myLooker = new LookingClass(0);
            int[][][] board;
            boolean done = false;
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter board size: ");
            boardSize = Integer.parseInt(myScanner.nextLine());
            board = new int[boardSize][boardSize][boardSize];
            System.out.println("Enter number of human players: ");
            numHumans = Integer.parseInt(myScanner.nextLine());
            Human myHumans = new Human(numHumans);
            //Test Print to see initial board results
            for (int floors = 0; floors < board.length; floors++)
            {
                for (int rows = 0; rows < board[floors].length; rows++)
                {
                    for (int columns = 0; columns < board[floors][rows].length; columns++)
                    {
                        System.out.print(board[floors][rows][columns]);
                        if (columns + 1 == board[floors][rows].length)
                        {
                            System.out.println(" ");
                        }
                    }
                    if (rows + 1 == board[floors].length)
                    {
                        System.out.println(" ");
                    }
                }
            }

            for (int i = 0; i < numHumans; i++)
            {
                System.out.println("Enter player " + (i + 1) + " name: ");
                myHumans.addHuman(myScanner.nextLine());
                System.out.println(myHumans.HA[i].getHumanName());
            }
            while (!done)
            {
                System.out.println(myHumans.HA[turns].getHumanName() + "'s turn.");
                System.out.println("Select your desired move location: (Z, X, Y)");
                System.out.println("Enter your X coordinate: ");
                int x = Integer.parseInt(myScanner.nextLine());
                System.out.println("Enter your Y coordinate: ");
                int y = Integer.parseInt(myScanner.nextLine());
                	for (int i = 0; i < boardSize; i++)
                	{
                		if (board[i][x][y] == 0)
                		{
                			board[i][x][y] = turns + 1;
                            turns++;
                            i = boardSize-1;
                		}
                		else 
                		{
                			System.out.println("Full");
                		}
                	}
                myLooker.check(board, turns);
                for (int floors = 0; floors < board.length; floors++)
                {
                    for (int rows = 0; rows < board[floors].length; rows++)
                    {
                        for (int columns = 0; columns < board[floors][rows].length; columns++)
                        {
                            System.out.print(board[floors][rows][columns]);
                            if (columns + 1 == board[floors][rows].length)
                            {
                                System.out.println(" ");
                            }
                        }
                        if (rows + 1 == board[floors].length)
                        {
                            System.out.println(" ");
                        }
                    }
                }
                if (myLooker.win == true)
                {
                    done = true;
                    System.out.println(myHumans.HA[turns - 1].getHumanName() + " won!");
                    for (int floors = 0; floors < board.length; floors++)
                    {
                        for (int rows = 0; rows < board[floors].length; rows++)
                        {
                            for (int columns = 0; columns < board[floors][rows].length; columns++)
                            {
                                System.out.print(board[floors][rows][columns]);
                                if (columns + 1 == board[floors][rows].length)
                                {
                                    System.out.println(" ");
                                }
                            }
                            if (rows + 1 == board[floors].length)
                            {
                                System.out.println(" ");
                            }
                        }
                    }
                }
                if (turns == numHumans)
                {
                    turns = 0;
                }
            }
        }
        catch (NumberFormatException myEx)
        {
            System.out.println("Invalid option.");
        }
    }
}


