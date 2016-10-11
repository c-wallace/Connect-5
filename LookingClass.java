/**
 * Created by Brody on 10/1/2016.
 */
public class LookingClass
{
    boolean win;
    int i;
    int t;
    int w;
    int x;
    int y;
    int z;
    int winCounter;
    public LookingClass(int i)
    {
        this.i = i;
    }
    public boolean look(int[][][] myBoard, int z, int x, int y, int t)
    {
        if (z < 0 || x < 0 || y < 0 || z >= myBoard.length || x >= myBoard[z].length 
              || y >= myBoard[z][x].length || myBoard[z][x][y] == 0 || myBoard[z][x][y]!= t)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public void check(int[][][]myBoard, int t)
    {  
        if (look(myBoard, z, x, y + 1, t) == true)// && myBoard[z][x][y + 1] == t) //Looks right
        {
             winCounter = 2;
             while (look(myBoard, z, x, y + 1, t) == true) // && myBoard[z][x][y + 1] == t)
             {
                  winCounter++;
                  y++;
             }
             System.out.println("Win counter: " + winCounter);
             won(winCounter);
        }
        else if (look(myBoard, z, x, y - 1, t) == true) //&& myBoard[z][x][y - 1] == t) //Looks left
        {
             winCounter = 2;
             while (look(myBoard, z, x, y - 1, t) == true) // && myBoard[z][x][y - 1] == t)
             {
                  winCounter++;
                  y--;
             }
             System.out.println("Win counter: " + winCounter);
             won(winCounter);
        }
        else if (look(myBoard, z, x - 1, y, t) == true) //&& myBoard[z][x - 1][y] == t) //Looks up a row
        {
             winCounter = 2;
             while (look(myBoard, z, x - 1, y, t) == true) // && myBoard[z][x - 1][y] == t)
             {
                  winCounter++;
                  x--;
             }
             System.out.println("Win counter: " + winCounter);
             won(winCounter);
        }
        else if (look(myBoard, z, x + 1, y, t) == true) // && myBoard[z][x + 1][y] == t) //Looks down a row
        { 
           winCounter = 2;
           while (look(myBoard, z, x + 1, y, t) == true) // && myBoard[z][x + 1][y] == t)
           {
                winCounter++; 
                x++;
           }
           System.out.println("Win counter: " + winCounter);
           won(winCounter);
        }
    }
    public void won(int w)
    {
        if (w == 5)
        {
            win = true;
        }
        else 
            win = false;
    }
}
