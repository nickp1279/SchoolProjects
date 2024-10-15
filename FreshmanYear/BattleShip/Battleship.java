/*
This code will ask two different users for their names, then randomly spread boats throughout a 5x5 area. It will rotate
asking either user to enter a guess at where a ship is. Then, if there is a ship, it will be marked as hit. If there is
no ship, then a message will be displayed saying you missed. Once one player gets all their ships sunk, the game will
end and a congratulations message will be displayed, along with the final look at what ships were hit and what ships
were missed for each fleet.
 */

// imports the necessary classes
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
public class Battleship
{
    public static void main(String[] args)
    {
        // makes new scanner
        Scanner keyboard = new Scanner(System.in);
        // makes new random class
        Random random = new Random();
        // prints statement
        System.out.print("First player's name: ");
        // asks for user input stored in player1
        String player1 = keyboard.next();
        //prints statement
        System.out.print("Second player's name: ");
        // asks for user input and stores it in player2
        String player2 = keyboard.next();
        // prints a new line
        System.out.println();
        // makes new array Fleet1
        String[][] Fleet1 = new String[6][6];
        // makes new array Fleet2
        String[][] Fleet2 = new String[6][6];

        // Fills the arrays with water
        for (int i = 0; i < Fleet1.length; i++)
        {
            for (int j = 0; j < Fleet1.length; j++)
            {
                Fleet1[i][j] = "\uD83C\uDF0A";
            }
        }
        for (int i = 0; i < Fleet2.length; i++)
        {
            for (int j = 0; j < Fleet2.length; j++)
            {
                Fleet2[i][j] = "\uD83C\uDF0A";
            }
        }

        // Fills the arrays with boats
        int randNum;
        for (int i = 0; i < Fleet1.length; i++)
        {
            randNum = random.nextInt(0,5);
            Fleet1[i][randNum] = "\uD83D\uDEA2";
        }
        for (int i = 0; i < Fleet2.length; i++)
        {
            randNum = random.nextInt(0,5);
            Fleet2[i][randNum] = "\uD83D\uDEA2";
        }
        System.out.println("All the ships have been positioned within the ocean areas.\n");

        // Starts the game

        // new variable set to false
        Boolean fleetSank = false;
        // new variable set to 0
        int sunkShipsP1Fleet = 0;
        // new variable set to 0
        int sunkShipsP2Fleet = 0;
        // declares new variable
        int player1GuessRow;
        // declares new variable
        int player1GuessColumn;
        //declares new variable
        int player2GuessRow;
        // declares new variable
        int player2GuessColumn;

        // starts a while loop
        while (fleetSank == false)
        {
            // prints a statement
            System.out.print(player1 + ", guess a latitude and longitude (e.g., 0 3) of a ship to fire at in " + player2 + "'s fleet [0, 5]: ");
            // sets variable to user input
            player1GuessRow = keyboard.nextInt();
            // sets variable to user input
            player1GuessColumn = keyboard.nextInt();
            // check if the guess equals boat
            if (Objects.equals(Fleet1[player1GuessRow][player1GuessColumn], "\uD83D\uDEA2"))
            {
                // prints a statement
                System.out.println("That's a hit .... a ship at [" + player1GuessRow + ", " + player1GuessColumn + "] in " + player2 + "'s fleet has just been fired!");
                // sets boat to fire
                Fleet1[player1GuessRow][player1GuessColumn] = "\uD83D\uDD25";
                // add 1 to variable
                sunkShipsP2Fleet++;
            }
            else
            {
                // prints a statement
                System.out.println("That's a miss .... there was no ship deployed at [" + player1GuessRow + ", " + player1GuessColumn + "]");
            }
            // prints a statement
            System.out.print(player2 + ", guess a latitude and longitude (e.g., 0 3) of a ship to fire at in " + player1 + "'s fleet [0, 5]: ");
            // sets variable to user input
            player2GuessRow = keyboard.nextInt();
            // sets variable to user input
            player2GuessColumn = keyboard.nextInt();
            // check if player guess is a boat
            if (Objects.equals(Fleet2[player2GuessRow][player2GuessColumn], "\uD83D\uDEA2"))
            {
                // prints a statement
                System.out.println("That's a hit .... a ship at [" + player2GuessRow + ", " + player2GuessColumn + "] in " + player1 + "'s fleet has just been fired!");
                // set user input to fire
                Fleet2[player2GuessRow][player2GuessColumn] = "\uD83D\uDD25";
                // add one to variable
                sunkShipsP1Fleet++;
            }
            else
            {
                // prints a statement
                System.out.println("That's a miss .... there was no ship deployed at [" + player2GuessRow + ", " + player2GuessColumn + "]");
            }
            // check if variable greater than 5
            if (sunkShipsP1Fleet > 5)
            {
                // set variable to true
                fleetSank = true;
            }
            // else if variable greater than 5
            else if (sunkShipsP2Fleet > 5)
            {
                // set variable to true
                fleetSank = true;
            }
        }
        // check if variable less than the other
        if (sunkShipsP1Fleet < sunkShipsP2Fleet)
        {
            // prints a statement
            System.out.println("WINNER! Congratulations " + player1 + ", you've sucessfully fired all ships in " + player2 + "'s fleet!");
        }
        else
        {
            // prints a statement
            System.out.println("WINNER! Congratulations " + player2 + ", you've sucessfully fired all ships in " + player1 + "'s fleet!");
        }
        // prints a statement
        System.out.print(player1 + "'s Fleet\t\t\t\t\t\t\t\t\t\t\t\t");
        // prints a statement
        System.out.println(player2 + "'s Fleet");
        // prints a statement
        System.out.print("------------\t\t\t\t\t\t\t\t\t\t\t\t");
        // prints a statement
        System.out.println("------------");

        // Prints the fleets
        for (int i = 0; i < Fleet1.length; i++)
        {
            for (int j = 0; j < Fleet1.length; j++)
            {
                System.out.print(Fleet1[i][j]);
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t");
            for (int j = 0; j < Fleet2.length; j++)
            {
                System.out.print(Fleet2[i][j]);
            }
            System.out.println();
        }
    }
}