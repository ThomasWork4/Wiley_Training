package BankingProjectV2.Profile

import BankingProjectV2.Accounts.{Account, CreditAccount, CurrentAccount, HelpToBuyISA, SavingsAccount}
import BankingProjectV2.CreditCard.CreditCard
import BankingProjectV2.Exceptions.TooManyAccountExceptions
import java.util.concurrent.TimeUnit
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

//Profile class that stores all the current statuses of subsequent objects
//As well as defines alot of the functionality for non-account related practices
class Profile(ID:Any){
  //Account portfolio stores all a users currently owned accounts
  var accountPortfolio = new ListBuffer[Account]()
  var currentAccount = new CurrentAccount("Current Account")
  accountPortfolio += currentAccount

  //Function responsible for showing all the currently owned accounts
  def showAccounts(): Unit = {
    println("You currently have: ")
    println("-------------------")
    //Show all the currently owned account
    for(account <- accountPortfolio) {
      if(account.AccountType != "Credit Account") {
        println(f"${account.AccountType} => Balance of £${account.AccountBalance}%1.2f")
      }
      else {
        //If the account is a credit account, show the owned credit cards instead of the credit account
        account.showCurrentCards()
      }
    }
    println("-------------------")
    println("")
    //Small delay before reprinting the reusable menu
    //Placed to achieve more readability
    TimeUnit.SECONDS.sleep(2)
  }

  @throws(classOf[TooManyAccountExceptions])
  //Function responsible for opening a new account
  def openAccount(): Unit = {
    //Print account menu
    println(
      """What type of account would you like to open?
        |--------------------------------------------
        |1.Savings
        |2.Credit
        |3.Lifetime ISA
        |--------------------------------------------
        |Please enter the corresponding number: """.stripMargin)
      var accountType = scala.io.StdIn.readInt()
    //Pattern matching for user input
      accountType match {
        //If the user doesn't already have one, open a new savings account
        //Then add it to the portfolio
        case 1 => if (!tooManyAccountsCheck("Savings Account")) {
          var sAccount = new SavingsAccount("Savings Account")
          accountPortfolio += sAccount
          println("A new savings account has been created\n")
        }
        //If the user doesn't already have one, open a new credit account
        //Then add it to the portfolio
        case 2 => if (!tooManyAccountsCheck("Credit Account")) {
          var cAccount = new CreditAccount("Credit Account", true)
          accountPortfolio += cAccount
          println("A new credit account has been created\n")
        }
        //If the user doesn't already have one, open a new ISA account
        //Then add it to the portfolio
        case 3 => if (!tooManyAccountsCheck("Help to buy ISA")) {
          var IAccount = new HelpToBuyISA("Help to buy ISA")
          accountPortfolio += IAccount
          println("A new ISA account has been created\n")
      }
    }
  }

  @throws(classOf[TooManyAccountExceptions])
  //Function responsible for checking whether the user already has an existing account
  def tooManyAccountsCheck(s: String):Boolean = {
    var AccountTotal: Map[String, Int] = Map()
    //Store all owned accounts in a map, with value 1
    for (account <- accountPortfolio) {
      AccountTotal += (account.AccountType -> 1)
    }
    //If the map contains the passed account
    //Then the user already has an account of this type
    //and we can throw a custom exception
    try {
      if (AccountTotal.contains(s)) {
        throw new TooManyAccountExceptions("You already have an account of this type.")
      }
      else{
        //Otherwise, return false because the account is not already owned
        return false
      }
    }
      //Catch the thrown custom exception and print exception message
    catch {
      case exp: TooManyAccountExceptions => println(exp)
    }
    //Return true, to signify we already have the passed account
    true
  }

  //Utility function used a lot for selecting an account from currently owned account
  def accountSelection():Int = {
    println("Which account would you like to select?: ")
    println("----------------------------------------")
    //For loop that prints the accounts owned in a numbered format
    //Hence why they are zipped with their indexes
    for ((account, index) <- accountPortfolio.zipWithIndex) print((index + 1) + ". " + account.AccountType+"\n")
    println("----------------------------------------")
    println("Please enter the corresponding number: ")
    var accountDetails = scala.io.StdIn.readInt()
    accountDetails match {
      //We need to return one less then their choice because we are working working indexes starting from zero
      case 1 => 0
      case 2 => 1
      case 3 => 2
      case 4 => 3
    }
  }

  //Function responsible for accepting cheques and updating balances
  def submitCheque():Unit = {
    println("Please enter the cheque ID number: ")
      var chequeID = scala.io.StdIn.readInt()
      //If the submitted chequeID is an integer less than 8 digit integer or less
      if (chequeID.toString.length < 9) {
        println("Please enter the cheque amount: ")
        var chequeAmount = scala.io.StdIn.readInt()
        //User needs to choose which account they would like to transfer the cheque balance to
        println("Which account would you like to transfer the cheque to? ")
        println("---------------------------------------------------")
        //Print the account portfolio formatted
        for ((account, index) <- accountPortfolio.zipWithIndex) {
          if (account.AccountType == "Credit Account") print((index + 1) + ". " + account.AccountType + "(Cannot transfer cheque to credit account)" + "\n")
          else print((index + 1) + ". " + account.AccountType + "\n")
        }
        println("---------------------------------------------------")
        println("Please enter the corresponding number: ")
        var selected = scala.io.StdIn.readInt() - 1
        //The user cannot submit cheques to credit accounts
        if (accountPortfolio(selected).AccountType == "Credit Account") {
          println("Cheque submission failed, please try again")
        }
          //They can however submit cheques to normal accounts
        else {
          //Update the account balance with the cheque amount
          accountPortfolio(selected).AccountBalance += chequeAmount
          println("The cheque has been processed.")
          //Print new balances
          println(f"The new balance of £${accountPortfolio(selected).AccountType} is ${accountPortfolio(selected).AccountBalance}%1.2f")
        }
      }
      else {
        //In case the cheque ID is not a valid one
        //Recall the function so that the user can try again
        println("ID Not valid")
        submitCheque()
    }
  }

  //Function that displays individual account options
  def accountOptions():Unit = {
    var selected_account = accountSelection()
    //If the selected account is a credit account it has slightly different options to a regular account
    if(accountPortfolio(selected_account).AccountType == "Credit Account"){
      println(
        """Your account options are:
          |-------------------------
          |1. Withdraw from a credit card
          |2. Deposit
          |3. Transfer
          |4. Order a new credit card
          |5. Show current credit cards
          |6. Pay off a credit card
          |-------------------------
          |Please enter the corresponding number: """.stripMargin)
    }
    else {
      //Print the options for a regular account
      println(
        """Your account options are:
          |--------------------------
          |1. Withdraw
          |2. Deposit
          |3. Transfer
          |--------------------------
          |Please enter the corresponding number: """.stripMargin)
    }
    var accountOptionChosen = scala.io.StdIn.readInt()
    //Pattern matching for user input
    accountOptionChosen match {
      case 1 => if(accountPortfolio(selected_account).AccountType == "Credit Account"){
        //For withdrawing from credit cards
        accountPortfolio(selected_account).withdrawFromCreditCards()
      }
      else{
        //For withdrawing from normal accounts
        accountPortfolio(selected_account).withdrawMoney()
      }
      //For depositing to an account
      case 2 => accountPortfolio(selected_account).depositMoney()
      //For transfering money
      case 3 => transferMoney(accountPortfolio(selected_account))
      //For ordering a new credit card
      case 4 => accountPortfolio(selected_account).orderNewCreditCard()
      //For showing the currently owned cards
      case 5 => accountPortfolio(selected_account).showCurrentCards()
      //For when the user would like to pay off a credit card
      case 6 => println("Which credit card would you like to pay off? ")
                println("---------------------------------------------")
        if (accountPortfolio(selected_account).creditCards.nonEmpty) {
          //User needs to select which credit card they would like to pay off
          for ((card, index) <- accountPortfolio(selected_account).creditCards.zipWithIndex) {
            println(index + 1 + f". ${card.cardType} => Balance of £${card.ccBalance}%1.2f")
          }
        }
        else {
          //Print a message if there are no cards for the user to pay off
          println("You do not have any active credit cards")
          return
        }
        println("---------------------------------------------")
        println("Please enter the corresponding number: ")
        var chosenCard = scala.io.StdIn.readInt()
        //Call the pay credit card method with the corresponding card chosen by the user
      accountPortfolio(selected_account).creditCards(chosenCard - 1).payCreditCard(accountPortfolio, accountPortfolio(selected_account))

    }
  }


  //Function responsible for transferring money between accounts
  def transferMoney(current_selected_account:Account): Unit = {
    println("Which account would you like to transfer money to? ")
    println("---------------------------------------------------")
    //Display possible accounts that the currently selected account can transfer to
    for ((account, index) <- accountPortfolio.zipWithIndex) print((index + 1) + ". " + account.AccountType + "\n")
    println("---------------------------------------------------")
    println("Please enter the corresponding number: ")
    var selection = scala.io.StdIn.readInt() - 1
    //If the destination account is not the same as the source account, then proceed
    if (accountPortfolio(selection).AccountType != current_selected_account.AccountType) {
      println("How much would you like to transfer?")
      var transferalAmount = scala.io.StdIn.readDouble()
      //If the user has enough money in their balance to transfer
      if (transferalAmount < current_selected_account.AccountBalance) {
        //Decrease the source account balance by the transferal amount
        current_selected_account.AccountBalance -= transferalAmount
        //Increase the destination account balacne by the transferal amount
        accountPortfolio(selection).AccountBalance += transferalAmount
        //Show the user the new balances of the accounts
        println(f"The new balance of ${current_selected_account.AccountType} is £${current_selected_account.AccountBalance}%1.2f")
        println(f"The new balance of ${accountPortfolio(selection).AccountType} is £${accountPortfolio(selection).AccountBalance}%1.2f")
      }

    }
      //If the user picks the same destination account as the source account
    else {
      println("Please pick an account other than the current selected one")
      //Recall the method to give them another try
      transferMoney(current_selected_account)
    }
  }
}