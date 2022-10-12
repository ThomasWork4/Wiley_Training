package BankingProject

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

//Main class used for the majority of user navigation
//And processes that aren't account specific
//This is where the user can see what he currently has
//Or add to his portfolio through new accounts
class InstanceOptions(ID:Any){
  //Each account automatically gets a current account
  //Which is added to innerAccounts, which is basically
  //a list of all the accounts owned by the customer
  var innerAccounts = new ListBuffer[Account]()
  var currentAccount = new CurrentAccount("Current Account")
  var creditAccount = new CreditAccount("Credit Account")
  //Add current account to our portfolio
  innerAccounts += currentAccount

  //Called inside the front end object when a user has logged in
  //and their previous account settings need to be restored
  def LoadPreviousSession(DataSplit:Array[String]):Unit = {
    //If the iterated value in DataSplit isn't an account or card name,
    //Skip it using breakable
    var Acceptable = List("Current Account", "Savings Account", "Help to buy ISA", "Rewards credit card", "Basic credit card", "Balance transfer card")
    for((entry,index) <- DataSplit.zipWithIndex) {
      breakable {
        if (!Acceptable.contains(entry)) {
          break
        }
        //Pattern matching for each account found in the saved account settings
        //Values are extracted from the ListBuffer mainly using indexes, which
        //is why we have zipped them with each value
        entry match {
          //Update the balance of the current account to whatever it was previously
          case "Current Account" => currentAccount.AccountBalance = DataSplit(index + 1).toDouble
          //Create a new savings account, update it's balance to whatever it was previously,
          //Then add it to the account portfolio
          case "Savings Account" => var sAccount = new SavingsAccount("Savings Account")
            sAccount.AccountBalance = DataSplit(index + 1).toDouble
            innerAccounts += sAccount
          //Create a new Help to buy ISA account, update it's balance to whatever it was previously,
          //Then add it to the account portfolio
          case "Help to buy ISA" => var IAccount = new HelpToBuyISA("Help to buy ISA")
            IAccount.AccountBalance = DataSplit(index + 1).toDouble
            innerAccounts += IAccount
          //Create a new Rewards credit card, update each of it's individual attributes to whatever they were previously
          //And then add it to the credit card portfolio (or credit card wallet -> creditCards) inside creditAccount
          //Make sure to add the credit account to the portfolio if it hasn't been already
          case "Rewards credit card" => var RewardsCard = new CreditCard(DataSplit(index + 1).toDouble, entry, DataSplit(index + 2).toDouble, DataSplit(index + 3).toInt)
            creditAccount.creditCards += RewardsCard
            if(!innerAccounts.contains(creditAccount)) {innerAccounts += creditAccount}
          //Create a new Basic credit card, update each of it's individual attributes to whatever they were previously
          //And then add it to the credit card portfolio (or credit card wallet -> creditCards) inside creditAccount
          //Make sure to add the credit account to the portfolio if it hasn't been already
          case "Basic credit card" => var basicCard = new CreditCard(DataSplit(index + 1).toDouble, entry, DataSplit(index + 2).toDouble, DataSplit(index + 3).toInt)
            creditAccount.creditCards += basicCard
            if(!innerAccounts.contains(creditAccount)) innerAccounts += creditAccount
          //Create a new Basic credit card, update each of it's individual attributes to whatever they were previously
          //And then add it to the credit card portfolio (or credit card wallet -> creditCards) inside creditAccount
          //Make sure to add the credit account to the portfolio if it hasn't been already
          case "Balance transfer card" => var BalanceTransferCard = new CreditCard(DataSplit(index + 1).toDouble, entry, DataSplit(index + 2).toDouble, DataSplit(index + 3).toInt)
            creditAccount.creditCards += BalanceTransferCard
            if(!innerAccounts.contains(creditAccount)) innerAccounts += creditAccount
        }
      }
    }
  }

  //Function that shows the user all accounts they current own
  //Including all credit cards and their balances
  def showAccounts(): Unit = {
    println("You currently have: ")
    //For each account owned, if it's a normal account
    //Print it's type and balance
    //If it's a credit account, print the card type and balance remaining
    for (account <- innerAccounts) {
      if (account.AccountType == "Credit Account") {
        println(account.showCurrentCards())
      }
      else {
        println(account.AccountType + " => Balance of £" + account.AccountBalance)
      }
    }
  }

  //Function responsible for opening a new account
  def openAccount(): Unit = {
    //Different account options
    println("What type of account would you like to open?\n1.Savings\n2.Credit\n3.Lifetime ISA")
    var accountType = scala.io.StdIn.readInt()
    //Pattern matching to validate the user's input
    accountType match {
      //Create a new savings account with the default settings and add it to the account portfolio
      case 1 => var sAccount = new SavingsAccount("Savings Account")
        innerAccounts += sAccount
        println("A new savings account has been created\n")
      //Create a new Credit account with the default settings and add it to the account portfolio
      case 2 => var cAccount = new CreditAccount("Credit Account")
        creditAccount = cAccount
        innerAccounts += creditAccount
        println("A new credit account has been created\n")
      //Create a new help to buy ISA account with the default settings and add it to the account portfolio
      case 3 => var IAccount = new HelpToBuyISA("Help to buy ISA")
        innerAccounts += IAccount
        println("A new ISA account has been created\n")
    }
  }

  //Function used to show the details of a specific account as opposed to all owned
  //This includes account type and current balance
  def showAccountDetails(): Unit = {
    var selected_account:Int = accountSelection()
    println("The current balance of your "+innerAccounts(selected_account).AccountType+" is £"+innerAccounts(selected_account).AccountBalance)
  }

  //This function was created for every instance where the user might need to choose
  //From their account portfolio, it's mostly to promote code re-usability
  def accountSelection():Int = {
    println("Which account would you like to select?: ")
    //For loop that prints the accounts owned in a numbered format
    //Hence why they are zipped with their indexes
    for ((account, index) <- innerAccounts.zipWithIndex) print((index + 1) + ". " + account.AccountType+"\n")
    var accountDetails = scala.io.StdIn.readInt()
    accountDetails match {
      //We need to return one less then their choice because we are working working indexes starting from zero
      case 1 => 0
      case 2 => 1
      case 3 => 2
      case 4 => 3
    }
  }

  //Function called when the user wants to invoke a specific action
  //with a specified account. It's mainly for presenting their options
  def accountOptions():Unit = {
    var selected_account = accountSelection()
    //If the account selected is a Credit account, we need to display the extra option it has
    if(innerAccounts(selected_account).AccountType == "Credit Account"){
      println("Your account options are:\n1. Withdraw\n2. Deposit\n3. Transfer\n4. Order a new credit card\n5. Show current credit cards")
    }
      //Otherwise just print the normal menu for all the basic accounts
    else {
      println("Your account options are:\n1. Withdraw\n2. Deposit\n3. Transfer")
    }
    var accountOptionChosen = scala.io.StdIn.readInt()
    //Pattern matching that calls the functions based on the user input
    accountOptionChosen match {
      //For withdrawing money
      case 1 => innerAccounts(selected_account).withdrawMoney()
      //For depositing money
      case 2 => innerAccounts(selected_account).depositMoney()
      //For transferring money from the selected account to a destination account
      case 3 => transferMoney(innerAccounts(selected_account))
      //For ordering a new credit card
      case 4 => innerAccounts(selected_account).orderNewCreditCard()
      //For showing the credit cards currently owned by the user
      case 5 => innerAccounts(selected_account).showCurrentCards()
    }
  }

  //Function responsible for transferring money between user accounts
  //This was intended to be extended to transfer money between external accounts
  //How this was not completed
  def transferMoney(current_selected_account:Account): Unit = {
    //Choose the destination account
    println("Which account would you like to transfer money to? ")
    for ((account, index) <- innerAccounts.zipWithIndex) print((index + 1) + ". " + account.AccountType + "\n")
    var selection = scala.io.StdIn.readInt() - 1
    //If the destination account isn't the one currently selected
    //Note making sure to decrement menu option as we are dealing with indexes starting from zero
    if (innerAccounts(selection).AccountType != current_selected_account.AccountType) {
      println("How much would you like to transfer?")
      var transferalAmount = scala.io.StdIn.readDouble()
      //If the user has enough funds in the account to transfer
      //Deduct from the source account
      //And increase the balance of the destination account
      if (transferalAmount < current_selected_account.AccountBalance) {
        current_selected_account.AccountBalance -= transferalAmount
        innerAccounts(selection).AccountBalance += transferalAmount
        //Show the user the new balances of the accounts
        println("The new balance of " + current_selected_account.AccountType + " is £" + current_selected_account.AccountBalance)
        println("The new balance of " + innerAccounts(selection).AccountType + "is £" + innerAccounts(selection).AccountBalance)
      }

    }
    else {
      //In case the user picked the source account as the destination account for the transferal
      println("Please pick an account other than the current selected one")
      transferMoney(current_selected_account)
    }
  }




}
