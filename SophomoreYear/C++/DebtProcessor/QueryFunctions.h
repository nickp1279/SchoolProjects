#pragma once

#include <vector>
#include <string>
using namespace std;

// Explain why you chose certain parameter types 
// (ref or not, const or not) for each function.

/* Pass by value seemed correct for all of the functions for the way I had my code set up
This is why I chose pass by value for all the functions except for if the customer's
name starts with a certain string of characters.
*/

// Write your functions' prototypes here  
vector<vector<string>> loadCustomers(int minNum, int maxNum);

int numOfCustomersInRange(vector<vector<string>> customerData);
int numOfCustomersInRange(vector<vector<string>> customerData, string state);

string highestDebt(vector<vector<string>> customerData);
string highestDebt(vector<vector<string>> customerData, string state);

int numOfCustomersStartWith(vector<vector<string>> customerData, string& name); // return by reference so that the name is correct for printing
int numOfCustomersStartWith(vector<vector<string>> customerData, string& name, string state); // same as above

int numOfCustomersOverDebtLimit(vector<vector<string>> customerData, int debtLimit);
int numOfCustomersOverDebtLimit(vector<vector<string>> customerData, int debtLimit, string state);

int numOfCustomersDebtFree(vector<vector<string>> customerData);
int numOfCustomersDebtFree(vector<vector<string>> customerData, string state);
