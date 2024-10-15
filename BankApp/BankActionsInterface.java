/*
 * This file is just the interface for the file User. This allows that files' methods to work
 * correctly. 
 * 
 * Author: Nick Pieroni
 */
package Projects.BankApp;

interface BankActionsInterface {
    void home();
    void depositFunds();
    void withdrawFunds();
    void updateAccount();
    void transferFunds();
    void cancelAccount();
}