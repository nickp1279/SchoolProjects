/* Implement your functions here. */
#include <cctype>
#include <string>

using std::string;
using std::stoi;

// implement the method to get the total number of words in the user's sample text
int GetNumOfWords(const std::string& userInputString) { 
    int numOfWords = 0; // variable to hold the numberof words
    bool word = false;  // set to true when iterating through a word, and false when iterator hits a whitespace
    char character; // variable to iterate through every character of the user's given text

    for (int i = 0; i < userInputString.length(); i++) {    // iterate through the entire length of the user's example string
        character = userInputString[i]; // set the character to the current character in the string

        if (isspace(character)) {   // if the current character is a space
            if (word) { // check if the iterator is on a new word
                numOfWords++;   // add 1 to the numOfWords
                word = false;   // then set word to false, since we've reached the end of the word
            }
        }
        else {  // if not a space
            word = true;    // set word to true if in the middle of a word or in the same word
        }
    }

    // MAKE SURE TO COUNT LAST WORD
    if (word) {
        numOfWords++;   // increment numOfWords
    }

    return numOfWords;  // return the resulting total number of words
}

// implement method to find a certain word/phrase in the user's sample text
int FindText(string searchWord, string userInputString) {
    int instances = 0;  // keep count of the total instances of the word/phrase

    for (int i = 0; i <= userInputString.length() - searchWord.length(); i++) { // iterate through the entire user example string minus the search word length, to handle double inputs
        if (userInputString.substr(i, searchWord.length()) == searchWord) { // check if the value of i to the length of searchWord equals searchWord
            instances++;    // increment instances
        }
    }

    return instances;   // return total instances
}

// implement method to see if all the spaces between words in the user's example text is 1, if not set it to 1
string ShortenSpace(string& userInputString) {
    string result = ""; // string to store result with limited spaces
    bool lastChar = false;      // if the last is being checked, set to true

    for (int i = 0; i < userInputString.length(); i++) {    // iterate through the entire length of use's example text
        if (userInputString[i] != ' ') {    // if not a space
            result += userInputString[i];   // add the iterating character to the result 
            lastChar = false;   // set last cahracter to false because its not the last character in the word
        }
        else if (!lastChar) { // if a space
            result += ' ';  // add a space to the result
            lastChar = true;    // set last character to true because its the last character in the word
        }
    }
    userInputString = result;   // set user's example text to the result

    return userInputString;  // return user's example text with the newly edited whitespaces
}

// implement a method to encrypt the user's example text with XOR using a 2 digit hexadeciaml key
string EncryptText(string hexKey, string& userInputString) {
    unsigned int key;   // store the true hexadeciaml value in the unsigned int key
    string temp = "";   // store encrypted characters one by one in the result string
    char character; // current character being affected by function

    key = stoi(hexKey, nullptr, 16);    // convert the hexKey to an integer

    for (int i = 0; i < userInputString.length(); i++) {    // iterate through the entire length of the user's provided string
        character = userInputString[i]; // set character to the current character in the user's provided text

        if (character != ' ') { // if the current character is not a space
            temp += static_cast<char>(character ^ key); // add the encrypted character to the temp
        }
        else {  // if character is a space
            temp += character;  // add the space to the temp
        }
    }
    userInputString = temp; // set the user's string to temp
    
    return userInputString; // return the user's example text
}

// implement a method to decrypt the user's example text
string DecryptText(string hexKey, string& userInputString) {
    hexKey = "0x" + hexKey; // handle error concerning non-valid hexKey
    unsigned int key;   // store the true hexadeciaml value in the unsigned int key 
    string temp = "";   // current character being affected by function
    char character; // current character being affected by function

    key = stoi(hexKey, nullptr, 16);    // convert the hexKey to an integer

    for (int i = 0; i < userInputString.length(); i++) {    // iterate through the entire length of the user's provided string
        character = userInputString[i]; // set character to the current character in the user's provided text

        if (character != ' ') { // if the current character is not a space
            temp += static_cast<char>(character ^ key); // add the encrypted character to the temp
        }
        else {  // if character is a space
            temp += character;  // add the space to the temp
        }
    }
    userInputString = temp; // set the user's string to temp

    return userInputString; // return the user's provided example text
}