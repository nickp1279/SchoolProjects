// Copyright by Nick Pieroni, 10/21/2024

// write your functions for the solution here
// For each function write its purpose,

#include <cctype>	// to handle string manipulation
#include <iostream>
#include <fstream>
#include <sstream>	// to handle separation of names, residence and money
#include <string>
#include <vector>
#include <algorithm> // to handle excess whitespaces when processing customerData

using namespace std;

/**
 * This will take all the customers from the file and add them to the 2D vector, allowing
 * elements to be taken from the list and manipulated.
 * 
 * @param minNum
 * @param maxNum
 * @return
 */
vector<vector<string>> loadCustomers(int minNum, int maxNum) {
	if (minNum > maxNum) {	// switch the values of max and min if they are swapped
		int temp = minNum;
		minNum = maxNum;
		maxNum = temp;
	}

    ifstream file("CustomerData.csv");
	vector<vector<string>> customerData;
	string currentLine;
	int count = 0;
	int customerCount = 0;

	while (getline(file, currentLine)) {	// iterate through the file and only add lines that are within range
		if (count >= minNum && count <= maxNum) {
			// { AI: ChatGPT
			vector<string> row; // to store the split parts of the line
			istringstream stream(currentLine);
			string part;

			// split the line by whitespaces and add each part to the row
			while (stream >> part) {
				part.erase(remove_if(part.begin(), part.end(), ::isspace), part.end()); // remove whitespace
				row.push_back(part);	
			}

			customerData.push_back(row); // add the row to the 2D vector
			//} end AI
		}

		if (count == maxNum) {	// break if the count has reached the end boundary
			break;
		}
		count++;
	}

	file.close();
	return customerData;
} // end loadCustomers

/**
 * This will just return the number of of customers in the dataset
 * 
 * @param customerData
 * @return
 */
int numOfCustomersInRange(vector<vector<string>> customerData) {
	return customerData.size();
} // end numOfCustomersInRange

/**
 * This will just return the number of of customers in the dataset, that
 * are in the state provided
 * 
 * @overload
 * @param customerData
 * @param state
 * @return
 */
int numOfCustomersInRange(vector<vector<string>> customerData, string state) {
	int count = 0;

	for (int i = 0; i < customerData.size(); i++) {
		if (customerData.at(i).at(1) == state) {
			count++;
		}
	}

	return count;
} // end numOfCustomersInRange

/**
 * this will iterate through the set and provide the name of the person with the highest debt
 * within the given range
 * 
 * @param customerData
 * @return 
 */
string highestDebt(vector<vector<string>> customerData) {
	string customer;
	double currentMax = stod(customerData.at(0).at(2));
	double currentNum;
	
	for (int i = 0; i < customerData.size(); i++) {
		currentNum = stod(customerData.at(i).at(2)); // change the 3rd column from string to double store in currentNum

		if (currentNum > currentMax) { // set new max if the current num is larger
			currentMax = currentNum;
			customer = customerData.at(i).at(0);
		}
	}

	return customer;
} // end highestDebt

/**
 * this will iterate through the set and provide the name of the person with the highest debt
 * within the given range and only if the state matches the state given
 * 
 * @overload
 * @param state
 * @param customerData
 * @return
 */
string highestDebt(vector<vector<string>> customerData, string state) {
	string customer;
	double currentMax = stod(customerData.at(0).at(2));
	double currentNum;
	
	for (int i = 0; i < customerData.size(); i++) {
		currentNum = stod(customerData.at(i).at(2)); // change the 3rd column from string to double store in currentNum

		if (customerData.at(i).at(1) == state) {
			if (currentNum > currentMax) { // set new max if the current num is larger
				currentMax = currentNum;
				customer = customerData.at(i).at(0);
			}
		}
	}

	return customer;
} // end highestDebt

/**
 * this will iterate through the data set and find the number of customers
 * that start with the string of characters given
 * 
 * @param customerData
 * @param name
 * @return
 */
int numOfCustomersStartWith(vector<vector<string>> customerData, string& name) {
	int count = 0;
	string currentName;

	if (!name.empty()) {
		// format name
		for (int i = 1; i < name.size(); i++) {	// change all letters entered for name to lower EXCEPT first letter
			name[i] = tolower(name[i]);
		}

		name[0] = toupper(name[0]);	// chenge first letter
		
		for (int i = 0; i < customerData.size(); i++) { 
			// check if the name in customerData starts with the same letters as provided in name
			if (customerData[i][0].substr(0, name.length()) == name) {
				count++;
			}
		}
	}

	return count;
} // end numOfCustomersStartWith

/**
 * this will iterate through the data set and find the number of customers
 * that start with the string of characters given and only if the customer
 * matches the state given
 * 
 * @overload
 * @param customerData
 * @param name
 * @param state
 * @return
 */
int numOfCustomersStartWith(vector<vector<string>> customerData, string& name, string state) {
	int count = 0;
	string currentName;

	// format name
	for (int i = 1; i < name.size(); i++) {	// change all letters entered for name to lower EXCEPT first letter
		name[i] = tolower(name[i]);
	}

	name[0] = toupper(name[0]);	// chenge first letter
	
	for (int i = 0; i < customerData.size(); i++) { 
		if (customerData.at(i).at(1) == state) {
			// check if the name in customerData starts with the same letters as provided in name
			if (customerData.at(i).at(0).substr(0, name.length()) == name) {
				count++;
			}
		}
	}

	return count;
} // end numOfCustomersStartWith

/**
 * this will iterate over the data set and find the number of customers that are over the debt limit
 * 
 * @param customerData
 * @param debtLimit
 * @return
 */
int numOfCustomersOverDebtLimit(vector<vector<string>> customerData, int debtLimit) {
	int count = 0;

	for (int i = 0; i < customerData.size(); i++) { 
		if (stod(customerData.at(i).at(2)) > debtLimit) {	// check if customer is over debt limit
			count++;
		}
	}

	return count;
} // end numOfCustomersOverDebtLimit

/**
 * this will iterate over the data set and find the number of customers that are over the debt limit
 * within the certain state given
 * 
 * @overload
 * @param customerData
 * @param debtLimit
 * @param state
 * @return count
 */
int numOfCustomersOverDebtLimit(vector<vector<string>> customerData, int debtLimit, string state) {
	int count = 0;

	for (int i = 0; i < customerData.size(); i++) { 
		if (customerData[i][1] == state) {
			if (stod(customerData[i][2]) > debtLimit) {	// check if customer is over debt limit
			count++;
			}
		}
	}

	return count;
} // end numOfCustomersOverDebtLimit

/**
 * this will iterate over the customerData and see how many people have no debt
 * 
 * @param customerData
 * @return count
 */
int numOfCustomersDebtFree(vector<vector<string>> customerData) {
	int count = 0;

	for (int i = 0; i < customerData.size(); i++) { 
		if (stod(customerData[i][2]) == 0) { // check if customer has no debt
			count++;
		}
	}

	return count;
} // end numOfCustomersDebtFree

/**
 * this will iterate over the customerData and see how many people have no debt
 * within the state given
 * 
 * @overload
 * @param customerData
 * @param state
 * @return
 */
int numOfCustomersDebtFree(vector<vector<string>> customerData, string state) {
	int count = 0;

	for (int i = 0; i < customerData.size(); i++) { 
		if (customerData.at(i).at(1) == state) {
			if (stod(customerData[i][2]) == 0) { // check if customer has no debt
				count++;
			}
		}
	}

	return count;
} // end numOfCustomersDebtFree
