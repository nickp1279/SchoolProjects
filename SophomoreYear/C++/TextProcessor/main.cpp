// Copyright Nick Pieroni 10/02/2024
// Coding Trail Notes 
/*
 [1] After the first submission I realized I had some formatting issues that needed wokred out
 such as issue concerning whitespaces and some edgecase issues. I will likely focus on this for 
 the main part of the iterations.
*/
/* 
 [2] For the second submission, I fixed some of the formatting issues and found an issue with the word counter that wouldn't 
 count the end of the words.
*/
/*
 [3] For submission 3, I reworked the encryption function, and finished the decryption function.
 They now handle edge cases that will allow almost any user input without crashing the code.
*/
// At the top of each version of the solution (major changes only), the program's changes or improvements are documented. 
// To get the 6 pt, for each menu item, there should be one trail.
#include <iostream>
#include <string>
#include "./assist_functions.h"

using std::string;
using std::cout;
using std::cin;
using std::endl;

// implement PrintMenu function here
int PrintMenu() {

    // print all the options for the menu, INCLUDING and newline character at the beggining
    cout << "\nMENU" << endl;
    cout << "w - Number of words" << endl;
    cout << "f - Find text" << endl;
    cout << "s - Shorten spaces" << endl;
    cout << "e - Encrypt the text" << endl;
    cout << "d - Decrypt the text" << endl;
    cout << "q - Quit" << endl;

    return 0;   // return 0 if no errors
}

// implement ExecuteMenu function here
bool ExecuteMenu(char userChoice, string userInputString) {
    // initalize variables
    string searchWord;  // store word to be searched for
    string hexKey = ""; // store the hexKey in a string, to be converted to hexadecimal later
    
    // switch statement will handle any input the user enters
    switch (userChoice) {
        case 'w':   // if user inputs w, run GetNumWords method
            cout << "Number of words:" << GetNumOfWords(userInputString) << endl;   // print the returned value from GetNumOfWords method
        break;

        case 'f':   // if the user inputs a f, run the FindText method
            cout << "Enter a word or phrase to be found:";  // prompt the user to enter a specific word/phrase to be found in their sample text
            cin.ignore();   // ignores the next character from the input 
            getline(cin, searchWord);   // store the entire line in searchWord
            cout << "\"" << searchWord << "\" " << "instances: " << FindText(searchWord, userInputString) << endl;  // print searchWord in quotes, then print instances and the returned value from FindText function
        break;
            
        case 's':   // if the user inputs a s, run the ShortenSpace method
            cout << "Edited text:" << ShortenSpace(userInputString) << endl;    // print the output of ShortenSpace function
        break;

        case 'e':   // if the user inputs a e, run the EncryptText method
            cout << "Enter a 2 digit hex key :";    // prompt user to enter a 2 digit hexadecimal value
            cin >> hexKey;  // store value in hexKey

            // handle if user enters uppercase letter for hexKey
            if (!isdigit(hexKey[0])) { // if first digit of hex key is not a digit, set it to the lowercase
                hexKey[0] = tolower(hexKey[0]);
            }
            if (!isdigit(hexKey[1])) { // if second digit of hex key is not a digit, set it to the lowercase
                hexKey[1] = tolower(hexKey[1]);
            }

            if ((hexKey.length() < 3)   // check if the hexKey is a valid 2 digit hex value
                && ((isdigit(hexKey[0]) || (hexKey[0] >= 'a' && hexKey[0] <= 'f')))
                && ((isdigit(hexKey[1]) || (hexKey[1] >= 'a' && hexKey[1] <= 'f')))) {
                
                cout << "Encrypted text with the key 0x: " << hexKey << endl; // prompt user to enter the last 2 digits of a hexadecimal value
                cout << EncryptText(hexKey, userInputString) << endl;   // print the output of the EncryptedText function
            }
            else {
                cout << "Invalid key input" << endl;
            }
        break;

        case 'd': // if the user inputs a d, run the DecryptText method
            cout << "Decrypted text:" << DecryptText(hexKey, userInputString) << endl;
        break;

        case 'q': // if the user inputs a q, quit the program
            cout << "Thank you for using the app" << endl;
            return true; // return true to be store in a variable in main
        break;

        default: // if the user inputs an unknown/unhandles character
            cout << "Invalid option!!" << endl;
        break;
    }

    return false; // return false to be stored in the variable in main
}

/*
 Main will be the entry point for the program and the center for execution of all the functions
*/
int main() {
    string userInput;   // string that stores "sample text"
    char userChoice;    // character that is used for what option the user selects

    cout << "Enter a sample text:" << endl; // prompt user to enter a text to be manipulated
    getline(cin, userInput);    // get the entire input for the sample text
    cout << "\nYou entered:" << userInput;  // reprint what was stored in the variable

    PrintMenu(); // call PrintMenu method
    
    bool quit = false;  // loop until quit equals true. (Until the user enters a 'q')
    while (!quit) {
        cout << "\nChoose an option (w, f, s, e, d or q):"; // prompt the user to enter a character to choose an option
        cin >> userChoice;  // store user's input in userChoice
        quit = ExecuteMenu(userChoice, userInput); // this is where the returned boolean value from ExecuteMenu is stored
    }

   return 0; // return 0 if no errors
}