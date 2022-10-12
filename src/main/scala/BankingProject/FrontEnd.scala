package BankingProject

import java.io.{BufferedWriter, File, FileWriter}
import scala.collection.mutable.{ArrayStack, ListBuffer}
import scala.util.Random
import com.github.tototoshi.csv._
import com.wiley.scalacohort.Tuples.Tuples.tuple
import scala.util.control.Breaks.{break, breakable}

object FrontEnd extends App {
  //Keep running the first menu until Exit variable is set to true
  var Exit = false
  do {
    //Login options visible to the user, allowing them a selection of input
    println("How can we help you today?\n1. Login to existing account\n2. Create new account\n3. Exit")
    var Entry = scala.io.StdIn.readInt()
    //Pattern matching to call functions based on the user input
    Entry match {
      case 1 => LoginProcedure()
      case 2 => CreateAccount()
      //do while loop terminates and so does the program
      case 3 => Exit = true
    }
  }
  while (!Exit)

  //Function responsible for creating a new account
  def CreateAccount(): Unit = {
    //User inputs for the account credentials
    println("Please enter a username: ")
    val Username = scala.io.StdIn.readLine()
    println("Please enter a password: ")
    val Password = scala.io.StdIn.readLine()
    //A couple of concatenated random sequences to make a unique ID for the account holder
    val r = scala.util.Random
    var Random_Chars = for (i <- 0 to r.nextInt(10)) yield r.nextPrintableChar
    var Random_Ints = for (i <- 1 to 5) yield r.nextInt(100)
    var new_ID_Vector = Random_Chars.concat(Random_Ints)
    val new_ID = new_ID_Vector.mkString("")
    /*New account object that begins, with a current account
    This is where most of the user interaction and display options
    Come from */
    var user = new InstanceOptions(new_ID)
    //Bring up our main menu making sure to pass our new InstanceOption
    //This menu should run endlessly until the user explicitly wants to quit
    reusableMenu(user, Username, Password, new_ID)
  }

  //Function responsible for logging into an existing account
  def LoginProcedure(): Unit = {
    //User inputs for the accounts NEW credentials
    println("Please enter your username: ")
    var Username = scala.io.StdIn.readLine()
    println("Please enter your password: ")
    var Password = scala.io.StdIn.readLine()
    //Open the CSV holding all account information and iterate each line
    val accountDatabase = CSVReader.open(new File("accountDatabase.csv"))
    val Iterator = accountDatabase.iterator
      while (Iterator.hasNext) {
        var Line = Iterator.next()
        //Triggers when we find the account with the correct username and password
        if (Line.head == Username && Line(1) == Password) {
          /*New account object that begins, with a current account
          Line(2), is the 3rd element on the CSV line and should be the userID */
          var user = new InstanceOptions(Line(2))
          //Split up and format all of the accounts previous custom settings
          //Including accounts owned, and their saved attributes
          var DataStored = Line(3).substring(11, Line(3).length - 1)
          var DataSplit = DataStored.split(", ")
          //Call the function responsible for setting all the previous custom attributes
          //and account settings correctly for the new session
          user.LoadPreviousSession(DataSplit)
          accountDatabase.close()
          //bring up our main reusable menu
          //that will act as our main point of navigation
          reusableMenu(user, Username, Password, Line(2))
        }
      }
      //Once the iterator has checked the entire CSV, we can be sure that no
      //Account exists with these credentials, therefore we give the user another attempt
      println("No account exists with these credentials, please try again")
      LoginProcedure()
    }


  //Reusable menu that acts as the user's main point of navigation and stops
  //The session from terminating
  def reusableMenu(obj:InstanceOptions, Username:String, Password:String, new_ID:String):Unit = {
    //Do while loop to keep the menu rerunning, everytime a functionality finished it's implementation
    var Exit = false
    do {
      //Main menu options
      println("Here's a list of things that you can do:\n1. Show all open accounts\n2. Open a new account\n3. Select Account for usage\n4. Exit")
      var Entry = scala.io.StdIn.readInt()
      //Pattern matching for the result of the user's input
      //Function called is dependent on the input submitted
      Entry match {
        //Show all of the accounts owned by this customer
        case 1 => obj.showAccounts()
        //Open a new account from scratch
        case 2 => obj.openAccount()
        //Select an account and manipulate it in some way
        //Whether that be depositing or withdrawing etc
        case 3 => obj.accountOptions()
        case 4 =>
          //If the user chooses to exit, we need to save their current state to
          //the CSV
          val writer = CSVWriter.open("accountDatabase.csv", append = true)
          var listBuffer = ListBuffer[Any]()
          //For each account owned by the user
          for (accounts <- obj.innerAccounts) {
            //If it's not a credit account, store it's type and current balance
            if (accounts.AccountType != "Credit Account") {
              listBuffer += (accounts.AccountType, accounts.AccountBalance)
            }
          }
          //For our credit account, we need to store each owned credit card
          //as well as it's individual attributes, as stipulated on line 120
          for (cards <- obj.creditAccount.creditCards) {
            listBuffer += (cards.cardType, cards.ccBalance, cards.creditLimit, cards.interestRate)
          }
          //Write all of the current details to the CSV
          //Note that the listBuffer is what contains the unique account information
          writer.writeRow(List(Username, Password, new_ID, listBuffer))
          writer.close()
          println("Thank you for your time!")
          //Now we can safely terminate the program
        System.exit(0)
      }
    }
    while (!Exit)
  }
}

