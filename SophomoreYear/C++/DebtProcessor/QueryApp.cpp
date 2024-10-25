// Copyright Nick Pieroni 10/21/2024

// Purpose: Allows for application of a credit card through a query process.
// Coding Trail for all your solution
/* Attempt #1: This was for the first attempt that I got a 33 on. After submitting
for the first time I realized there were mutliple print formatting issues and 
issues with some of the counters all that I would fix. */

/* Attempt #2: This is for the attempt when I dipped down into a 0. I thought 
I had a solution for the formatting and more importantly the counting errors
however I made it worse. I will try another way soon. */

/* Attempt #3: This is for the attempt when I got a 67. I finally figured out what
was causing the issues with my counter always being exactly one off. It was an
issue with how the customerData was initialized and the initial data stored.
What appeared to be happening was the code was skipping the first boundary
of data and exceeding the boundary of data on the maximum side. This is why
all my asnwers were really close but off by just a little. */

#include <iostream>
#include <fstream>
#include <sstream>	// to handle separation of names, residence and money
#include <string>
#include <vector>
#include <cctype>	// to handle string manipulation
#include "./QueryFunctions.h"
using namespace std;

/**
 * use the main method to execute the methods and manipulate the data set
 * 
 * @return 0
 */
int main() {
   // Starting part 
   int minNum;
   int maxNum;
   int numOfCustomers;
   int debtLimit;
   string state;
   string name;

   // Program Intro
   cout << "---------------------------------------------" << endl;
   cout << "Customer Query Application"<< endl;
   cout << "---------------------------------------------" << endl;
   cout << "Enter customer numbers range:" << endl;
   cin >> minNum >> maxNum;
   vector<vector<string>> customerData = loadCustomers(minNum, maxNum);
   
   cout << "Enter the customer's name:" << endl;
   cin >> name;
   cout << "Enter debt limit:" << endl;
   cin >> debtLimit;
   cout << "Enter the state initials:" << endl;
   cin >> state;
   
   // Complete the rest of the solution
   // for the entire set
   cout << "---------------------------------------------" << endl;
   cout << "U.S. Report" << endl;
   cout << "---------------------------------------------" << endl;
   cout << "#of customers: " << numOfCustomersInRange(customerData) << endl;
   cout << "Highest debt: " << highestDebt(customerData) << endl;
   numOfCustomers = numOfCustomersStartWith(customerData, name);
   cout << "#of customer names begining with '" << name << "': " << numOfCustomers << endl;
   cout << "#of customers with debt over $" << debtLimit << ": " << numOfCustomersOverDebtLimit(customerData, debtLimit) << endl;
   cout << "#of customers debt free: " << numOfCustomersDebtFree(customerData) << endl;

    
	for (int i = 0; i < state.length(); i++) { // format state abbreviation
		state[i] = toupper(state[i]);
	}

	// report for specific state
	cout << "---------------------------------------------" << endl;
	cout << state << " Report" << endl;
	cout << "---------------------------------------------" << endl;
	cout << "#of customers: " << numOfCustomersInRange(customerData, state) << endl;
	cout << "Highest debt: " << highestDebt(customerData, state) << endl;
	numOfCustomers = numOfCustomersStartWith(customerData, name, state);
	cout << "#of customer names begining with '" << name << "': " << numOfCustomers << endl;
	cout << "#of customers with debt over $" << debtLimit << ": " << numOfCustomersOverDebtLimit(customerData, debtLimit, state) << endl;
	cout << "#of customers debt free: " << numOfCustomersDebtFree(customerData, state) << endl;

   return 0;
} // end main
