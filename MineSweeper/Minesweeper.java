/**
 * Nick Pieroni
 * CSE 174-A
 * This code simulates the game minesweeper. It uses user input to move around the map and avoid mines. Making 15
 * different moves while staying alive.
 */
// imports necessary classes
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    // declare method initializeGrid to fill the playField and mineField with brown squares
    private static void initializeGrid(String[][] table) {
        for (String[] strings : table) {
            Arrays.fill(strings, "\uD83D\uDFEB");
        }
    }
    // declare method placeMines
    private static void placeMines(String[][] table) {
        // creates new random class
        Random random = new Random();
        // determines what type of mine will be planted
        String[] mineTypes = {"\uD83D\uDEA8", "\uD83D\uDCA3"};
        int randNum;
        int i;
        int j;
        String mineType;
        int minesPlaced = 0;
        // place 20 mines
        while (minesPlaced < 20) {
            // random number between 0 and 1
            randNum = random.nextInt(0, 2);
            mineType = mineTypes[randNum];
            i = random.nextInt(10);
            j = random.nextInt(10);
            // this stops the bomb generation in (0,0), (0,1), (1,0)
            if (((i == 0) && (j == 0)) || ((i == 0) && (j == 1)) || ((i == 1) && (j == 0))) {
                // set equal to brown box
                table[i][j] = "\uD83D\uDFEB";
                // check if theres already a bomb there and if there is continue the iteration
            } else if (!table[i][j].equals("\uD83D\uDEA8") && !table[i][j].equals("\uD83D\uDCA3")) {
                table[i][j] = mineType;
                minesPlaced++;
            }
        }
    }
    // declare printGrid
    private static void printGrid(String[][] table) {
        // iterate through table and print it
        for (String[] strings : table) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.print("\n");
        }
    }

    private static int[] detectNearbyMines(String[][] table, String[][] table2, int x, int y) {
        int[] nearbyMines = new int[2];
        // check if the box above the player is a detectable bomb (make sure that x + 1 does not equal 10 for the index)
        if ((x + 1) != 10) {
            if (table[x + 1][y].equals("\uD83D\uDCA3")) {
                // replace the bomb with a check mark
                table2[x + 1][y] = table[x + 1][y] = "\u2705";
                nearbyMines[0]++;
            }
            // check if the box above the player is an undetectable mine
            if (table[x + 1][y].equals("\uD83D\uDEA8")) {
                nearbyMines[1]++;
            }
        }
        if ((x - 1) != -1) {
            if ((table[x - 1][y]).equals("\uD83D\uDCA3")) {
                table2[x - 1][y] = table[x - 1][y] = "\u2705";
                nearbyMines[0]++;
            }
            if (table[x - 1][y].equals("\uD83D\uDEA8")) {
                nearbyMines[1]++;
            }
        }
        if ((y - 1) != -1) {
            if (table[x][y - 1].equals("\uD83D\uDCA3")) {
                table2[x][y - 1] = table[x][y - 1] = "\u2705";
                nearbyMines[0]++;
            }
            if (table[x][y - 1].equals("\uD83D\uDEA8")) {
                nearbyMines[1]++;
            }
        }
        if ((y + 1) != 10) {
            if (table[x][y + 1].equals("\uD83D\uDCA3")) {
                table2[x][y + 1] = table[x][y + 1] = "\u2705";
                nearbyMines[0]++;
            }
            if (table[x][y + 1].equals("\uD83D\uDEA8")) {
                nearbyMines[1]++;
            }
        }
        return nearbyMines;
    }

    private static boolean checkWin(String[][] table) {
        boolean gameOver = false;
        int counter = 0;
        // counts black boxes
        for (String[] strings : table) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals("\u2B1B")) {
                    counter++;
                }
            }
        }
        // if there are 15 black boxes then set gameOver to true
        if (counter == 15) {
            gameOver = true;
        }
        return gameOver;
    }

    public static void main(String[] args) {
        boolean gameOver = false;
        String[][] mineField = new String[10][10];
        String[][] playField = new String[10][10];
        String[][] moveField = new String[10][10];
        // fills the grid with brown boxes
        initializeGrid(playField);
        initializeGrid(mineField);
        initializeGrid(moveField);
        placeMines(mineField);
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (!gameOver) {
            // set the first box that the player starts at to a black box
            playField[0][0] = "\u2B1B";
            mineField[0][0] = "\u2B1B";
            moveField[0][0] = "\u2B1B";
            System.out.println("W/A/S/D to move, Q to quit: ");
            String line = scanner.nextLine();
            // using a scanner read what the user inputs and change the x and y coordinates respectively
            if (line.equalsIgnoreCase("q"))
                break;
            if (line.equalsIgnoreCase("a"))
                if (x == 0 && y == 0) {
                    printGrid(playField);
                    continue;
                }
                else
                    // keeps the player inside the grid
                    y = Math.max(0, y - 1);
            if (line.equalsIgnoreCase("d"))
                y = Math.min(9, y + 1);
            if (line.equalsIgnoreCase("w"))
                if (x == 0 && y == 0) {
                    printGrid(playField);
                    continue;
                }
                else
                    x = Math.max(0, x - 1);
            if (line.equalsIgnoreCase("s"))
                x = Math.min(9, x + 1);
            int[] mines = detectNearbyMines(mineField, playField, x, y);
            // don't replace checkmark with black box on the playField
            if (!playField[x][y].equals("\u2705") && !mineField[x][y].equals("\uD83D\uDEA8")) {
                mineField[x][y] = "\u2B1B";
                playField[x][y] = "\u2B1B";
            }
            moveField[x][y] = "\u2B1B";
            printGrid(playField);
            System.out.println(mines[0] + " regular mine(s) were detected and swept nearby, but there's still " + mines[1] + " undetectable mine(s) nearby!");
            gameOver = checkWin(moveField);
            // If a user lands on an undetectable mine on their last move, then they lose
            if (mineField[x][y].equals("\uD83D\uDEA8"))
                gameOver = true;
            if (gameOver) {
                // changes to fire emoji
                if (mineField[x][y].equals("\uD83D\uDEA8")) {
                    mineField[x][y] = "\uD83D\uDD25";
                    System.out.println("Sorry. You lost.");
                    printGrid(mineField);
                } if (!mineField[x][y].equals("\uD83D\uDD25")) {
                    System.out.println("Congratulations, you won!");
                    printGrid(mineField);
                }
            }
        }
    }
}