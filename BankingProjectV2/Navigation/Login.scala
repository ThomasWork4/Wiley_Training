package BankingProjectV2.Navigation
import BankingProjectV2.Exceptions.{ExistingAccountException, TooManyAccountExceptions}
import BankingProjectV2.Profile.Profile
import BankingProjectV2.SQL_Account_Storage.{DoesAccountExist, LoadAccount, UpdateAccount}
import scala.collection.mutable.{ArrayStack, ListBuffer}


//Main object that deals with all login processes
//as well as the reusable menu
object Login{

  //Main executable thread
  def main(args: Array[String]): Unit = {
    var Exit = false
    //Do while loop for the login menu
    do {
      println(
        """How can we help you today?
          |-----------------------------------------
          |1. Login to existing account
          |2. Create new account
          |3. Exit
          |-----------------------------------------
          |Please enter the corresponding number: """.stripMargin)
      try {
        //Try catch loop integrated with pattern matching to avoid any invalid user inputs
        var Entry = scala.io.StdIn.readInt()
        Entry match {
          //Initiate login procedure
          case 1 => LoginProcedure()
          //Initiate new account procedure
          case 2 => CreateAccount()
          //Terminate the program
          case 3 => Exit = true
          //If the user types any integer that isn't valid
          //Restart the main thread with a warning message
          case _ => println("Sorry, this is not a valid input!")
            main(null)
        }
      }
        //Catch the number format exception when the user attempts to enter
        //a non integer input
      catch {
        //Restart the main thread with a warning message
        case e: NumberFormatException => println("Sorry, this is not a valid input!")
          main(null)
      }
    }
    while (!Exit)


    //Function responsible for creating a fresh account from scratch
    @throws(classOf[ExistingAccountException])
    def CreateAccount(): Unit = {
      //User inputs for the account credentials
      println("Please enter a username: ")
      val Username = scala.io.StdIn.readLine()
      println("Please enter a password: ")
      val Password = scala.io.StdIn.readLine()
      //Create a new credential checker object
      var Checker = new DoesAccountExist
      try {
        //Try block to test whether the account credentials already exist inside the SQL database
        if (Checker.Check(Username, Password)) {
          //If they do, throw a the corresponding custom exception
          throw new ExistingAccountException("An account already exists with these details! Please try again!")
        }
        else {
          //Use the random package to create a new ID
          //That consists of random characters and integers
          //Which are concatenated into a new Indexes sequence
          val r = scala.util.Random
          var Random_Chars = for (i <- 0 to r.nextInt(10)) yield r.nextPrintableChar
          var Random_Ints = for (i <- 1 to 5) yield r.nextInt(100)
          var new_ID_Vector = Random_Chars.concat(Random_Ints)
          val new_ID = new_ID_Vector.mkString("")
          //Create a new profile object for the user, this is where most of the important information for a user is stored
          //This can also be referred to as their overall account
          var user = new Profile(new_ID)
          //Call the reusable menu to start implementing the main bank functionality
          reusableMenu(user, Username, Password, new_ID)
        }
      }
      catch {
            //Catch the custom exception and print the corresponding error message
        case exp: ExistingAccountException => println(exp)
      }
      //Re-run the function so that the user can have another attempt
      //At providing valid username and password credentials that don't already exist
      CreateAccount()
    }

    //Function responsible from logging in and loading all user data from the previous session
    def LoginProcedure(): Unit = {
      //User inputs for their current credentials
      println("Please enter your username: ")
      var Username = scala.io.StdIn.readLine()
      println("Please enter your password: ")
      var Password = scala.io.StdIn.readLine()
      var AccountChecker = new DoesAccountExist
      //If the account does exist, then we can assume they have provided the correct username and password
      if (AccountChecker.Check(Username, Password)) {
        var user = new LoadAccount()
        //Call the class function responsible from retrieving all the users data from SQL
        //and loading it into a new profile object
        //This simulates logging into the previous session where nothing will have changed
        var LoadedAccountAndID = user.Load(Username, Password)
        //Call the reusable menu to start implementing the main bank functionality
        reusableMenu(LoadedAccountAndID._1, Username, Password, LoadedAccountAndID._2)
      }
      else {
        //If the account already exists in mySQL, then print a warning message and recall the function
        //So that they can try again
        println("Sorry this account does not exist, please try again!")
        LoginProcedure()
      }
    }

    @throws(classOf[NumberFormatException])
    //Function responsible for all first page navigation
    //This reusable menu is in an infinite do, while loop so that the user
    //Can "stay logged in" even after the current task finishes executing
    def reusableMenu(obj: Profile, Username: String, Password: String, new_ID: String): Unit = {
      var Exit = false
      //Print the menu options
      do {
        println(
          """Here's a list of things that you can do:
            |-----------------------------------------
            |1. Show all open accounts
            |2. Open a new account
            |3. Select Account for usage
            |4. Submit Cheque
            |5. Exit
            |-----------------------------------------
            |Please enter the corresponding number: """.stripMargin)
        //main try catch block that deals with invalid user input,
        //Anything that happens in the entire program, happens inside this block
        //So we can assume it covers all user inputs that may result in a
        //NumberFormatException
        try {
          var Entry = scala.io.StdIn.readInt()
          //Pattern matching for user input
          Entry match {
            //Show all owned account
            case 1 => obj.showAccounts()
            //Open a new account
            case 2 => obj.openAccount()
            //Show the options related to each account
            case 3 => obj.accountOptions()
            //Submit a cheque to the account
            case 4 => obj.submitCheque()
            //If the user safely quits
            case 5 =>
              //Create 4 lists that will store ALL the current account attributes and variables
              //Anything that needs to be saved to the database and reloaded for when they next log in
              var DataStrings = ListBuffer[String]()
              var DataDoubles = ListBuffer[Double]()
              var DataBoolean = ListBuffer[Boolean]()
              var DataInt = ListBuffer[Int]()
              //Add the current username,password and ID
              DataStrings += Username
              DataStrings += Password
              DataStrings += new_ID

              //Filter each account so we have an object for each owned account that we can extract their corresponding attributes
              //If the resultant list from the filter is empty, we know that the user didn't have an account of that type
              var CurrentAccount = obj.accountPortfolio.filter(_.AccountType == "Current Account")
              var savingsAccount = obj.accountPortfolio.filter(_.AccountType == "Savings Account")
              var ISA = obj.accountPortfolio.filter(_.AccountType == "Help to buy ISA")
              DataDoubles += CurrentAccount.head.AccountBalance
              var cAccount = obj.accountPortfolio.filter(_.AccountType == "Credit Account")

              //If the credit account doesn't exist, add default values to the corresponding lists
              if (cAccount.isEmpty) {
                var emptyCase = List(false, false, 0.0, "", 0.0, 0, false, 0.0, "", 0.0, 0, false, 0.0, "", 0.0, 0)
                for (element <- emptyCase) {
                  if (element == false) {
                    DataBoolean += false
                  }
                  if (element == 0.0) {
                    DataDoubles += 0.0
                  }
                  if (element == "") {
                    DataStrings += ""
                  }
                  if (element == 0) {
                    DataInt += 0
                  }
                }
              }
                //If the credit account does exists, we need to find out what credit cards it currently contains
              else {
                DataBoolean += true
                var basicCard = cAccount.head.creditCards.filter(_.cardType == "Basic credit card")
                var rewardsCard = cAccount.head.creditCards.filter(_.cardType == "Rewards credit card")
                var balancetransfercard = cAccount.head.creditCards.filter(_.cardType == "Balance transfer card")
                var CardList = List(basicCard, rewardsCard, balancetransfercard)

                //For each card that the user owns, if it doesn't exist
                //Add default values
                for (card <- CardList) {
                  if (card.isEmpty) {
                    DataBoolean += false
                    DataDoubles += 0.0
                    DataStrings += ""
                    DataDoubles += 0.0
                    DataInt += 0
                  }
                    //If it does exist, add all their attributes to the corresponding lists
                  else {
                    DataBoolean += true
                    DataDoubles += card.head.ccBalance
                    DataStrings += card.head.cardType
                    DataDoubles += card.head.creditLimit
                    DataInt += card.head.interestRate
                  }
                }
              }

              //For both the savings and ISA accounts
              var AccountList = List(savingsAccount, ISA)
              for (account <- AccountList) {
                //If they don't exist, add default values to the corresponding lists
                if (account.isEmpty) {
                  DataBoolean += false
                  DataDoubles += 0.0
                }
                else {
                  //If they do existm add their attributes to the corresponding lists
                  DataBoolean += true
                  DataDoubles += account.head.AccountBalance
                }
              }

              var updateInstance = new UpdateAccount
              //Now we need to either create a new mySQL account entry with all the attributes and variables we have just saved
              //or update the ones that currently exist that may have been changed in this instance
              updateInstance.update(DataStrings, DataInt, DataDoubles, DataBoolean, Username, Password)
              //exit message
              println("See you next time! Goodbye.")
              System.exit(0)

              //In case of invalid integer input
            case _ => println("Invalid input.")
          }
        }

          //Catch number format exception if the user doesn't input an int
          //where an int is required
        catch {
          case e: NumberFormatException => println("Sorry, this is not a valid input!")
            //recall the reusable menu so that the instance doesn't terminate
            reusableMenu(obj, Username, Password, new_ID)
        }
      }
      while (!Exit)
    }
  }
}

