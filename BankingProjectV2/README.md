Banking Project
--------------------------------------------------------------
The goal of this project was to create a basic banking system, with extensive functionality, whilst attempting to cover as many as the Scala training topics as possible. 

Prerequisites Required Before Running
--------------------------------------------------------------
- An active mySQL server must be installed and running on the local machine before attempting to run the program
- All three classes inside the SQL_Account_Storage directory must be updated so that the username and passwords match the credentials of your mySQL connection. Please see the TODO lines on each of the classes
- A new accountStorage table must be created inside an accountStorage database with the correct field names. Copy and paste the text file inside SQL_Account_Storage into your mySQL workbench to do this.

How To Run
--------------------------------------------------------------
- Program starts from the login object, please run from here
- Ensure that you safe exit using the corresponding menu options, terminating the program via Intellij will cause any account updates not to be saved to mySQL
- Always ensure that the corresponding number keys are used to navigate all menus unless indicated otherwise

Simplified Class Hierarchy 
--------------------------------------------------------------
![Alt text](ClassHierarchy.PNG "Optional title")

Functionality provided
--------------------------------------------------------------
- Create an account with a unique username and password, a unique ID is provided automatically
- Account credentials and class states are saved to a mySQL database
- Account credenditals are updates as required 
- Login to an existing account and load the state of your account from previous sessions automatically
- Each customer account is automatically loaded with a Current account
- New accounts can be added including: Savings account, Help to buy ISA, Credit Account
- Customers have the ability to display account information, either indivdually, or their entire portfolio
- Customers can submit cheques to their profile to be transfered to an account of their choosing 
- Credit Accounts have the ability to apply for new credit cards, each with their own individual traits
- Customers can display their credit card portfolio for complete transparency 
- Funds can be deposited to a selected accounts 
- Funds can be withdrawn from selected accounts (Includes exception handling for withdrawing too many funds)
- Funds can be transfered from one account to another
- The program is mostly failsafe and will handle invalid inputs at every stage
- Program menu has been updates to look more aesthetically pleasing to each customer
- Latency has been simulated to give the program a real feel to it 
- Reusable menu with print infinitely so that the program doesn't terminate at the end of a single process
NOTE all code has been commented with a brief statement regarding it's use case in the program

Scala Topics Covered
--------------------------------------------------------------
- Basic Classes: InstanceOption Class, CreditCardClass
- Abstract Classes: Account
- Case classes: CurrentAccount, SavingsAccount, HelpToBuyISA 
- Inheritance: CreditAccount
- Field overriding
- Method overriding
- Custom Exceptions: NotEnoughFundsException
- Try, Catch blocks for excepton handling
- Pattern matching 
- More Control structures: for loops, do while loops, forEach loops
- Using dependencies (Custom CSV dependency acquired from GitHub)
- Print formatting (\n, printf, println($))
- A plethora of functions
- User inputs / console interaction
- String manipulation (.substring, .split, .concat)
- Collections framework (ArrayBuffers, ListBuffers and their counterparts)
- Various numerical operations
- Access modifiers
- throws keyword

Improvements to be made
--------------------------------------------------------------
- SQL table has to be made manually 
- Users cannot transfer between eachother
