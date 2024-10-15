/*
 * This file is to define the constructor, getter and setter methods, as well as the methods to perform various banking
 * functions.
 * 
 * Author: Nick Pieroni
 */

package Projects.BankApp;

// import all the required packages
import java.util.ArrayList;
import java.util.Scanner;

public class User implements BankActionsInterface {
    public Scanner keyboard = new Scanner(System.in);
    public String name, userName, password, email, routingNum, checkingBalance, savingsBalance;

    // constructor for the class User
    public User(String name, String userName, String password, String email, String routingNum,
            String checkingBalance, String savingsBalance) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.routingNum = routingNum;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
    }

    // Getter methods
    String getName() {
        return name;
    }

    String getUserName() {
        return userName;
    }

    String getPassword() {
        return password;
    }

    String getEmail() {
        return email;
    }

    String getRoutingNum() {
        return routingNum;
    }

    String getCheckingBalance() {
        return checkingBalance;
    }

    String getSavingsBalance() {
        return savingsBalance;
    }

    // Setter methods
    void setName(String name) {
        this.name = name;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setRoutingNum(String routingNum) {
        this.routingNum = routingNum;
    }

    void setCheckingBalance(String checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    void setSavingsBalance(String savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // print all the data of the user
    public void home() {
        System.out.println("Full name: " + getName() + "\r\n" +
                "Username: " + getUserName() + "\r\n" +
                "Password: " + getPassword() + "\r\n" +
                "Email: " + getEmail() + "\r\n" +
                "Routing Number: " + getRoutingNum() + "\r\n" +
                "Checking account balance: $" + getCheckingBalance() + "\r\n" +
                "Savings account balance: $" + getSavingsBalance());
    }

    // allows the user to deposit funds into their account
    public void depositFunds() {
        String userInput;
        double depositAmount = 0, newAccountBalance;

        // prompt the user to choose which account to deposit into
        System.out.print("Which account would you like to deposit into? (E to exit)\r\n" + //
        "1. Checking account\r\n" + //
        "2. Saving account\r\n" + //
        "Enter your choice: ");
        userInput = keyboard.nextLine();

        // check that the user is not trying to exit, then ask for the deposit amount
        if (!userInput.equalsIgnoreCase("e")) {
            System.out.print("Enter the amount to deposit: $");
            depositAmount = keyboard.nextDouble();
            keyboard.nextLine();
        }

        // run the user's input through the switch statement
        switch (userInput) {
            case "1":

                // set new account balance to the current checking balance + the deposit amount - the fee
                newAccountBalance = Double.parseDouble(getCheckingBalance()) + (depositAmount * 0.98);
                setCheckingBalance(String.valueOf(newAccountBalance));

                newAccountBalance = Double.parseDouble(getSavingsBalance()) + (depositAmount * 0.02);
                setSavingsBalance(String.valueOf(newAccountBalance));
                System.out.println("Deposit successful. New checking account balance: $" + getCheckingBalance());

                // add the new total into the userData
                App.userData.get(App.userIndex).remove(5);
                App.userData.get(App.userIndex).add(5, getCheckingBalance());
                App.userData.get(App.userIndex).remove(6);
                App.userData.get(App.userIndex).add(6, getSavingsBalance());
            break;

            case "2":

                // set new account balance to the current savings balance + the deposit amount - the fee
                newAccountBalance = Double.parseDouble(getSavingsBalance()) + (depositAmount * 0.98);
                setSavingsBalance(String.valueOf(newAccountBalance));
                System.out.println("Deposit successful. New savings account balance: $" + getSavingsBalance());

                // add the new total into the userData
                App.userData.get(App.userIndex).remove(6);
                App.userData.get(App.userIndex).add(6, getSavingsBalance());
            break;

            case "e":
                
                // exit 
                System.out.println("Transaction cancelled.");
            break;

            default:
                System.out.println("Error, please enter a valid number.");
            break;
        }
    }

    // method allowing the user to take funds from the account
    public void withdrawFunds() {
        String userInput;
        double withdrawAmount = 0, newAccountBalance;
        System.out.print("Which account would you like to withdraw from? (E to exit)\r\n" + //
        "1. Checking account\r\n" + //
        "2. Saving account\r\n" + //
        "Enter your choice: ");
        userInput = keyboard.nextLine();

        // check to make sure the user isn't trying to exit
        if (!userInput.equalsIgnoreCase("e")) {
            System.out.print("Enter the amount to deposit: $");
            withdrawAmount = keyboard.nextDouble();
            keyboard.nextLine();
        }

        // run a switch statement based on the user's input
        switch (userInput) {
            case "1":
                newAccountBalance = Double.parseDouble(getCheckingBalance()) - (withdrawAmount * 1.05);

                // check to make sure that the user will not go into debt
                if (newAccountBalance > 0) {
                    setCheckingBalance(String.valueOf(newAccountBalance));
                    System.out.println("Withdraw successful. New checking account balance: $" + getCheckingBalance());
                    App.userData.get(App.userIndex).remove(5);
                    App.userData.get(App.userIndex).add(5, getCheckingBalance());
                } else {

                    // print statement if the user's funds are insufficient
                    System.out.println("Sorry, you don't have the avaliable funds! Current checking account balance: $" + getCheckingBalance());
                }
            break;

            case "2":
                newAccountBalance = Double.parseDouble(getSavingsBalance()) - (withdrawAmount * 1.05);

                // check to make sure that the user will not go into debt
                if (newAccountBalance > 0) {
                    setSavingsBalance(String.valueOf(newAccountBalance));
                    System.out.println("Withdraw successful. New savings account balance: $" + getSavingsBalance());
                    App.userData.get(App.userIndex).remove(6);
                    App.userData.get(App.userIndex).add(6, getSavingsBalance());
                } else {

                    // print statement if the user's funds are insufficient
                    System.out.println("Sorry, you don't have the avaliable funds! Current savings account balance: $" + getSavingsBalance());
                }
            break;

            case "e":

                // allows user to cancel transaction
                System.out.println("Transaction cancelled.");
            break;

            default:
                System.out.println("Error, please enter a valid number.");
            break;
        }
    }

    // method allows user to update their name and password
    public void updateAccount() {
        String newName, newPass;

        // prompt the user to enter their new full name
        System.out.print("Updating profile...\r\n" +
                "Enter your new full name (E to exit): ");
        newName = keyboard.nextLine();

        // if the user doesn't want to exit
        if (!newName.equalsIgnoreCase("e")) {

            // set their new name and remove their old one
            setName(newName);
            App.userData.get(App.userIndex).remove(0);
            App.userData.get(App.userIndex).add(0, getName());
    
            // prompts the user to enter their new password
            System.out.print("Enter your new password: ");
            newPass = keyboard.nextLine();

            // set their new password to the userData file
            setPassword(newPass);
            App.userData.get(App.userIndex).remove(2);
            App.userData.get(App.userIndex).add(2, getPassword());
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Update cancelled.");
        }
    }

    // allows user to transfer funds between other people within the bank
    public void transferFunds() {
        String otherEmail = getEmail(), userInput;
        double transferAmount;
        boolean exit = false;

        // prompt the user to enter an email
        System.out.print(
                "Users can transfer money only to accounts associated with the same bank (internal accounts)!\r\n" +
                        "Enter the recipient's email (E to exit): ");
        userInput = keyboard.nextLine();

        // make sure the user does not want to exit
        if (userInput.equalsIgnoreCase("e")) {
            exit = true;
            System.out.println("Transaction cancelled.");
        }

        ArrayList<String> toUserList = new ArrayList<String>();
        int counter = 0, toUserIndex, userDataLength = App.userData.size();
        boolean noEmailFound = true;

        // iterate through userData to find the user whos email matches the one inputed
        while (userDataLength > 0 && !exit) {

            toUserList = App.userData.get(counter);
            otherEmail = toUserList.get(3);
            toUserIndex = userDataLength;

            // if the email is found, prompt the user to enter an amount to transfer
            if (userInput.equals(otherEmail) && !userInput.equals(getEmail())) {
                System.out.print("Enter the amount to transfer: $");
                transferAmount = keyboard.nextDouble();
                
                /*
                * if the email is found then perform the transfer by removing the amount
                * from the fromUser and adding it to the balance to the toUser. 
                */
                if (Double.parseDouble(getCheckingBalance()) >= transferAmount) {

                    // set the balance to the old balance minus the amount to be transfered
                    setCheckingBalance(String.valueOf(Double.parseDouble(getCheckingBalance()) - transferAmount));
                    App.userData.get(App.userIndex).remove(5);
                    App.userData.get(App.userIndex).add(5, getCheckingBalance());

                    // give that ammount to the recipient
                    toUserList.add(5, String.valueOf(Double.parseDouble(toUserList.get(5)) + transferAmount));
                    toUserList.remove(6);
                    System.out.println("Transfer successful.");
                } else {
                    System.out.println("Sorry, insufficient funds.");
                }
                noEmailFound = false;
            }
            counter++;
            userDataLength--;
        }

        if (noEmailFound && !exit) {

            // print statement incase the user inputed an invalid email
            System.out.println("No account associated with this email!");
        }
    }

    // method allows users to delete their account
    public void cancelAccount() {
        String username, password, userInput;
        boolean quit = false;

        /*
         * As long as quit is false, do the following. Prompt the user to anser if they want
         * to delete their account. check the user input and if they say yes, then take their
         * username and password, then check the userData for that user and delete it if it is 
         * found.
         */
        while (!quit) {
            System.out.print("Would you like to delete your account? Y/N: ");
            userInput = keyboard.nextLine();

            switch (userInput) {
                case "y":
                    System.out.print("Enter your username: ");
                    username = keyboard.nextLine();

                    System.out.print("Enter your password: ");
                    password = keyboard.nextLine();

                    if (username.equals(getUserName()) && password.equals(getPassword())) {
                        App.userData.remove(App.userIndex);
                        System.out.println("Your account has been deleted successfully! Re-routing you to the home page.");
                        quit = true;
                    } else {
                        System.out.println("Error, invalid username or password.");
                        quit = true;
                    }
                break;

                case "n":
                    quit = true;
                break;

                default:
                    System.out.println("Error, enter a valid character.");
                break;
            }
        }
    }
}

// subclass using the superclasses' constructor
class RegularUserClass extends User {
    public RegularUserClass(String name, String userName, String password, String email,
            String routingNum, String checkingBalance, String savingsBalance) {
        super(name, userName, password, email, routingNum, checkingBalance, savingsBalance);
    }
}