/*
 * This file is the app class for the Bank App system. This file will pull the data from storage into this class and allow
 * the user to perform various actions such as signing up a new account, logging in to a current account or just exiting 
 * the program.
 * 
 * Author: Nick Pieroni
*/

package Projects.BankApp;

// import all the necessary packages
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static ArrayList<ArrayList<String>> userData = new ArrayList<ArrayList<String>>();
    public static Scanner keyboard = new Scanner(System.in);
    public static int userIndex;

    // checks if the inputed index equals anything else from userdata
    static boolean checkUserData(int checkIndex, String checkedElement) {
        ArrayList<String> currentUserList = new ArrayList<String>();
        String element = checkedElement, otherElement = "";
        boolean exists = false;

        // iterate through the userdata checking the corresponding index for a certain string
        for (int i = 0; i < userData.size(); i++) {
            currentUserList = userData.get(i);
            otherElement = currentUserList.get(checkIndex);

            // if the element exists, set the variable to true
            if (element.equalsIgnoreCase(otherElement)) {
                exists = true;
            } else if ((exists == false) && (!element.equals(otherElement))) {
                exists = false;
            }
        }
        return exists;
    }

    // this will load all the userData from the storage file into the arraylist
    static void loadUserData() {
        try {
            Path inputFilePath = Paths.get("BankApp", "BankInput.csv");

            // check if the file doesn't exist
            if (Files.notExists(inputFilePath)) {
    
                // create a new csv file and add the following data into the first row
                File inputCSVFile = new File("BankApp" + File.separator + "BankInput.csv");
                
                // if a file does exist then iterate throught the file and add the elements to userData
            } else if (Files.exists(inputFilePath)) {
                Scanner inputFileScanner = new Scanner(inputFilePath);
                String line;
                String[] elements = new String[6];

                while (inputFileScanner.hasNextLine()) {
                    userData.add(new ArrayList<>());
                    line = inputFileScanner.nextLine();
                    elements = line.split(",");
                    
                    for (String element : elements) {
                        userData.get(userData.size() - 1).add(element);
                    }
                }
                inputFileScanner.close();
            }
            // catch any error with loading the data
        } catch (IOException e) {
            System.out.println("Error while attempting to load account data into this file.");
            e.printStackTrace();
        }
    }

    // saves the user's data back into the input file
    static void saveUserData() {
        try {
            // check to make sure userData is not = 0, otherwise will cause a crash
            if (userData.size() != 0) {
                FileWriter write = new FileWriter("BankApp\\BankInput.csv");
                Scanner inputFileScanner = new Scanner("BankApp\\BankInput.csv");
                ArrayList<String> currentLine;
                String currentElement;

                // iterate through user data, writing each element into the input file
                for (int i = 0; i < userData.size(); i++) {
                    currentLine = userData.get(i);
    
                    for (int j = 0; j < currentLine.size(); j++) {
                        currentElement = currentLine.get(j);
                        write.append(currentElement + ",");
                    }
                    write.append("\n");
                }
                inputFileScanner.close();
                write.close();
            }
            // catch any error with saving userData to a file
        } catch (IOException e) {
            System.out.println("Error while attempting to save account data to file.");
            e.printStackTrace();
        }
    }

    // geerates a unique routing number for each new user
    static String generateRoutingNumber() {
        Random random = new Random();
        boolean equalsPreviousRoutingNum = false;
        String routingNum = "", otherRoutingNum = "";

        // rune while the number does not equal the previous routing numbers by other accounts
        while (!equalsPreviousRoutingNum) {
            otherRoutingNum = "";
            equalsPreviousRoutingNum = false;

            // create a new string and add a new random digit to it for a total of 10 digits
            for (int i = 0; i < 10; i++) {
                routingNum += String.valueOf(random.nextInt(9));
            }
    
            // for the size of userdata, check to see if any of the previous routing nums equal the newly generated one
            equalsPreviousRoutingNum = !checkUserData(5, otherRoutingNum);
        }
        return routingNum;
    }
    
    // allow users to sign up if they dont have an account
    static void signUp() {
        ArrayList<String> newUserData = new ArrayList<String>();
        String username, userInput, initialDeposit, email;
        boolean equalsPreviousUsername = false, equalsPreviousEamil = false;

        // prompt the user to enter their full name and store it in newUserData
        System.out.print("Enter your full name: ");
        userInput = keyboard.nextLine();

        /*
         * prompt the user to enter a username and keep prompting them to until their username
         * does not equal a username in the inputfile
         */
        while (!equalsPreviousUsername) {
            System.out.print("Enter a username: ");
            username = keyboard.nextLine();
            equalsPreviousUsername = checkUserData(1, username);
    
            // if does not equal previous username, continue with the rest of the sign up
            if (!equalsPreviousUsername) {
                newUserData.clear();
                newUserData.add(userInput);
                newUserData.add(username);
                System.out.print("Enter a password: ");
                newUserData.add(keyboard.nextLine());

                System.out.print("Enter your email address (YOUR_USERNAME@fictionalBank.com): ");
                email = keyboard.nextLine();

                while (!equalsPreviousEamil) {
                    equalsPreviousEamil = false;

                    // check to make sure the email is correctly formatted
                    if (email.contains("@fictionalBank.com")) {
                        equalsPreviousEamil = checkUserData(3, email);

                        newUserData.add(email);
                        newUserData.add(generateRoutingNumber());
            
                        System.out.print("Enter your initial deposit amount: $");
                        userInput = keyboard.nextLine();
                        initialDeposit = String.valueOf(Double.parseDouble(userInput) * 0.98);
                        newUserData.add(initialDeposit);

                        initialDeposit = String.valueOf(Double.parseDouble(userInput) * 0.02);
                        newUserData.add(initialDeposit);
                
                        System.out.println("Account created successfully.");
        
                        // store all the data in userData and then save the data to the file and break out of the loop
                        userData.add(newUserData);
                        saveUserData();
                        equalsPreviousUsername = true;
                        equalsPreviousEamil = true; 
                    } else {

                        // print a statement if the email is incorrect
                        System.out.print("Enter a valid email address (YOUR_USERNAME@fictionalBank.com): ");
                        email = keyboard.nextLine();
                    }
                }
            } else {

                // print a statement if the username is already in use
                equalsPreviousUsername = false;
                System.out.println("Sorry, this username is taken. Enter another username.");
            }
        }
    }


    // allows users to login if they have an account and allows them to perform banking functions
    static void logIn() {
        String userInput, storedUsername, storedPassword = "";
        ArrayList<String> storedUserData = new ArrayList<String>();
        boolean correctLogin = false, correctUsername = false, correctPassword = false;
        String email = "", routingNum = "", checkingBalance = "", savingsBalance = "";
        
        // prompt the user to enter their username and password
        System.out.print("Enter your username: ");
        String username = keyboard.nextLine();

        System.out.print("Enter your password: ");
        String password = keyboard.nextLine();

        // check to see if the entered username and password equals anything from userData
        for (int i = 0; i < userData.size(); i++) {
            storedUserData = userData.get(i);
            storedUsername = storedUserData.get(1);

            if (username.equals(storedUsername)) {
                correctUsername = true;
                userIndex = i;
            }
            storedPassword = storedUserData.get(2);
            if (password.equals(storedPassword)) {
                correctPassword = true;
            }
        }

        String name;

        /*
         * if both the username and password is correct, set all the variables to the
         * corresponding index in the userData list. Then create a new instance of
         * User, using all the variables to initalize the variables.
         */
        if (correctUsername && correctPassword) {
            correctLogin = true;

            storedUserData = userData.get(userIndex);
            name = storedUserData.get(0);
            username = storedUserData.get(1);
            password = storedUserData.get(2);
            email = storedUserData.get(3);
            routingNum = storedUserData.get(4);
            checkingBalance = storedUserData.get(5);
            savingsBalance = storedUserData.get(6);

            // create new instance of regular user class
            RegularUserClass CurrentUser = new RegularUserClass(name, username, password, email, routingNum, checkingBalance, savingsBalance);

            System.out.println("Login successful... ");

            /*
             * repeat the following as long as the login is correct. Print a set of options
             * for the user to pick from and prompt the uesr to enter a character.
             * Once the enter a character, run the character through a switch statement
             * and perform the function requested, then save the data to the file 
             * via the saveUserData method.
             */
            while (correctLogin) {
                System.out.println("*********Main Menu**********\r\n" + //
                        "Enter your choice: (H)ome\r\n" + //
                        "Enter your choice: (D)eposit\r\n" + //
                        "Enter your choice: (W)ithdraw\r\n" + //
                        "Enter your choice: (U)pdate\r\n" + //
                        "Enter your choice: (T)ransfer\r\n" + //
                        "Enter your choice: (C)ancel\r\n" + //
                        "Enter your choice: (L)ogOut\r\n" + //
                        "*****************************");
                userInput = keyboard.next();

                // check the input to see if it matches any of the cases then perform the function given
                switch (userInput) {
                    case "h":
                        CurrentUser.home();
                    break;
                    
                    case "d": 
                        CurrentUser.depositFunds();
                    break;
                    
                    case "w":
                        CurrentUser.withdrawFunds();
                    break;

                    case "u":
                        CurrentUser.updateAccount();
                    break;

                    case "t":
                        CurrentUser.transferFunds();
                    break;

                    case "c":

                        // when cancelling the account, make sure the account is removed before returning the user to the home page
                        CurrentUser.cancelAccount();
                        saveUserData();
                        correctLogin = checkUserData(userIndex, CurrentUser.getName());
                    break;

                    case "l":
                        correctLogin = false;
                    break;

                    default:
                        System.out.println("Error, please enter a valid character.");
                    break;
                }
                saveUserData();
            }
        } else {

            // print a statement if either username or password does not match any existing accounts
            System.out.println("Error, wrong username or password.");
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        String userInput;
        loadUserData();

        /*
         * while not exit, print a set of options for the user to choose from. then prompt the
         * user to input a character to choose a function. Run the input through a switch
         * statement and perform the function requested. 
         */
        while (!exit) {
            System.out.println("*******Fictional Bank Page********\r\n" + //
                    "***** Enter your choice: (S)ign Up\r\n" + //
                    "***** Enter your choice: (L)ogIn\r\n" + //
                    "***** Enter your choice: (E)xit\r\n" + //
                    "**********************************");
            userInput = keyboard.next();

            // check if the user input equals any of the cases then perfom the function
            switch (userInput) {
                case "s":
                    signUp();
                break;

                case "l":
                    logIn();
                break;

                case "e":
                    exit = true;
                break;
                
                default: 
                    System.out.println("Error, please enter a valid character.");
                break;
            }
        }
        keyboard.close();
    }
}