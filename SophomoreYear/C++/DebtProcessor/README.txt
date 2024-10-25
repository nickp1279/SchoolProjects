This is a project given to me by my professor in CSE-278. The purpose of this is to create functions that 
iterate through the CustomerData.csv and perform various functions. Detailed descriptions of the functions
can be found in the QueryFunctions.cpp file above each function.

NOTE: the instructions are in 2 parts, the first part was on the online interactive textbook and the second part
will be what was posted on canvas.

The intstructions are down below:
------------------------------------------------------------------------------------------------------------------------------
Program Specifications This project aims to design and implement a query application for listing customers who have credit card debt using modular design.

You will design your solution using multiple files.  Do not forget to add your code-trial as comment on top of your program for major revised submission 

You are free to use any variable types or objects covered in the course to design your solution. However, global variables should not be used.

To complete the project, you should:

Write as many functions as needed to achieve the desired functionality. Each input option should have at least one function, which should be called from the main.
Each function should be designed to accomplish a specific task. If the input option has multiple tasks, they should be split into sub-functions.
Parameters should be designed to be as efficient as possible.
For each function, write an inline comment explaining why you chose certain parameter types (ref or not, const or not).
You will see five files for this programming project.
CustomerData.csv is the customer file for reading the data in the program.
QueryFunctions.h : It is a header file for your functions
QueryFunctions.cpp : It is a source file for your functions
QueryApp.cpp: It is a main file that your app starts to run from this file.
Makefile: You will design a makefile to compile, run and clean your files automatically using the make tool on the console shell.
CustomerData.csv file contains 10000 customers in three colunms: customer name, state of residence, and amount of credit card debt. 

The starting code is given in the QueryApp.cpp. Program queries the customers based on the followings inputs

- Customer number range 

- Customer's name begin with :

- Debt lower limit 

- State name (two-letters abbrevations)

Program takes all these inputs from the user then searches customer credit card debt information. Identify statistics such as the number of customer names that begin with 'S', the number of customers with no debt, and the number of customers that live in a specific state.

Step 0 :  The program asks starting and ending customer row number(inclusive) for querying. After getting the input range, the applicaton reads the file and stores all customers between the input range (including starting and ending numbers) into a storage structure on the memory. Program should be able to control the range boundaries even getting the input range as ending and starting order. Design a function for loading requested customers from file to the memory (you can use any storage structures we've learned so far). Function should return how many customers are loaded into memory. Submit for grading to confirm three tests pass.

Note: This program is designed for incremental development. Complete each step and submit for grading before starting the next step. Only a portion of tests pass after each step but confirm progress.

Ex: If input is:

---------------------------------------------
Customer Query Application
---------------------------------------------
Enter customer numbers range:
1000 1800
Enter the customer's name:
A
Enter debt limit:
100
Enter the state initials:
CA
the output for Step 0 is:

---------------------------------------------
U.S. Report
---------------------------------------------
#of customers: 801
 

Ex: If input for Step 0 is:

Enter customer numbers range:
1700 11
the output is:

---------------------------------------------
U.S. Report
---------------------------------------------
#of customers: 1690


Step 1: Design a function to identify the customer with the highest debt in a given customer range. Output a report header, number of customers, and the person's name with the highest debt. Submit for grading to confirm two tests pass.

Ex: If input of Step1 is:

Enter customer numbers range: 
1 1000 
the output of Step 1 is:

---------------------------------------------
U.S. Report
---------------------------------------------
#of customers: 1000
Highest debt: Sullivan


Step 2. Input a string and design a function that counts all customer names that begin with the specified string and returns the results from the function. Ex: How many customer names begin with 'B' ? Output the number of customer names that start with the specified string. The input can be mached with the name without being case sensitive. Submit for grading to confirm three tests pass.

 Ex: If input is:

Enter customer numbers range: 
1000 1 
Enter the customer's name: 
paR
the partial output for Step2 is:

#of customers: 1000
Highest debt: Sullivan
#of customer names begining with 'Par': 3


Step 3: Input a debt limit (integer). Design a function that counts and returns the number of customers that have debt higher than the specified debt limit. Output the following results. Submit for grading to confirm two tests pass.

Ex: If input is:

Enter customer numbers range: 
1 2000 
Enter the customer's name: 
p
Enter debt limit: 
250
the output is:

#of customers: 2000
Highest debt: Sullivan
#of customer names begining with 'P': 111
#of customers with debt over $250: 1562


Step 4:  Design a function that counts and returns the number of customers that have no debt. Output all results. Submit for grading to confirm two tests pass.

Ex: If input is:

Enter customer numbers range: 
1 2000 
Enter the customer's name: 
p
Enter debt limit: 
250

the output is:

#of customers: 2000
Highest debt: Sullivan
#of customer names begining with 'P': 111
#of customers with debt over $250: 1562
#of customers debt free: 438


Step 5:  Repeat steps 1 - 4 for all customers living in the specified state. Overload your functions by adding a state parameter to your existing functions. If state input is not valid you should display as reset, as shown below. The state search should be case-insensitive. Output all results including a header for the state report. Submit for grading to confirm all tests pass gradually.

Ex: If input is:

---------------------------------------------
Customer Query Application
---------------------------------------------
Enter customer numbers range:
1000 1800
Enter the customer's name:
A
Enter debt limit:
100
Enter the state initials:
ca
the output is:

---------------------------------------------
U.S. Report
---------------------------------------------
#of customers:801
Highest debt: Sullivan
#of customer names begining with 'A': 16
#of customers with debt over $100: 635
#of customers debt free: 166
---------------------------------------------
CA Report
---------------------------------------------
#of customers:77
Highest debt: Brown
#of customer names begining with 'A': 1
#of customers with debt over $100: 57
#of customers debt free: 20
------------------------------------------------------------------------------------------------------------------------------

Project#2 

This project aims to design and implement a query application for listing customers who have credit card debt. 

You will complete INDIVIDUALLY.
Acceptable resources are
Zybook,
Supplementary books (listed in the syllabus) 
Professor's and  Teaching Assistant's office hours, and 
CPP reference website :  https://en.cppreference.com/w/Links to an external site.
Limited use of Generative AI tools such as Gemini, ChatGPT, Bing, Bard, DALL-E, GitHub Copilot, etc. within the boundaries and limitations is acceptable. However, students are responsible for their submissions, and their solutions are subject to the same plagiarism standards as if the student-authored them. Students must label sections of code generated using AI via suitable comments as below

// { AI : Name of the AI
     Code generated with the help of AI goes here
// } end-AI
Questions & clarifications: Post all questions and clarifications regarding project#2 on the discussion forum: Week8 and Week9: Q & A
Your code should exhibit good style as described in cpplint (name, date, file description on top, inline comments, indentation).  
All your programs should be executable. In other words, they should contain no syntax errors.
You can write your code on VSCode then copy your code to Zybook. I strongly recommend you create the coding trail of your work on Zybook. The coding trail shows your work history. This trail is important evidence of your effort on the homework. For each major submission to zybook ,  explain what you change on the code to improve your program
Late homework will be deducted 10% for each day after the due date. 
I will not answer questions about code within 8 hours of the programming assignment deadline. So, starting early is the key to the success
Check CSE Academic Integrity Policy (Links to an external site.) to remember which behaviors are acceptable which are not !!!
Rubric for Part2 and Report

Item

Excellent

(100%)

Good

(75%)

Satisfactory

(50%)

Unsatisfactory (25%)

Zero

 

Functionality (67p)

Modular Design (15p)

Pass all test cases with splitting your code correctly using multiple functions and multiple files

 Depending on how many test cases passed, splitting your code correctly using multiple functions and multiple files

Code of trail/ code of history

5 pt

For each major revised submission,on the top of the program,  what you improved/changed/solved  was written

Good, but not every submission was trailed

The half submission was trailed / limited history

Not help to understand the improvement of the code/ not enough history

No explanation

No trail

No history

Documentation (8pt)

 

Fully documented,including purpose of program, inline comments (4pt fro each cpp file)

Good but not
everything is
documented. (3pt)

Basic 
documentation. (2pt)

Documentation
does not help
understand the
code. (1pt)

No
documentation. (0pt)

Makefile 5pt

testing makefile on the zybook console

able to compile all files using modular compiling (3pt)

able to run application from make (1pt)

able to clear all object and executable file from make (1pt)

 

Depending on make command result for makefile

Here are some guidelines that will help you:

Assignments should be solved using the specific techniques and algorithms you have been learning in class. Don't search for solutions online because you won't learn the right concepts, your code will likely not work as specified, and this is considered a violation of the Academic Integrity Policy (Links to an external site.).
Don't share your code with anyone on homework projects. Don't ask for someone else to share their code. Attempts to copy code and then change it to look slightly different nearly always fail, and lead to students being found responsible for a violation of the Academic Integrity Policy
Don't post assignments or solutions to sites like Chegg or CourseHero because that is considered a violation of this course's Academic Integrity Policy . Plus, you should know that Miami's Academic Integrity office has full access to the materials on such sites.
Don't reuse your old work or someone else's old work for this class, because doing so is considered a violation of the Academic Integrity Policy 
Don't manipulate the auto-grade system by coding that matches only the output of the problem because doing so is considered a violation of the Academic Integrity Policy
We're here to support your learning! Join our office hours

Good coding!
------------------------------------------------------------------------------------------------------------------------------
