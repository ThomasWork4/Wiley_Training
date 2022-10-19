package BankingProjectV2.Profile

import BankingProjectV2.Accounts.{Account, CreditAccount, CurrentAccount, HelpToBuyISA, SavingsAccount}
import BankingProjectV2.CreditCard.CreditCard
import BankingProjectV2.Exceptions.TooManyAccountExceptions

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

class Profile(ID:Any){
  var accountPortfolio = new ListBuffer[Account]()
  var currentAccount = new CurrentAccount("Current Account")
  accountPortfolio += currentAccount

  def LoadPreviousSession(DataSplit:Array[String]):Unit = {
    if(DataSplit.contains("Current Account")){
      var index = DataSplit.indexOf("Current Account")
      currentAccount.AccountBalance = DataSplit(index + 1).toDouble}
    if(DataSplit.contains("Savings Account")){
      var index = DataSplit.indexOf("Savings Account")
      var sAccount = new SavingsAccount("Savings Account")
      sAccount.AccountBalance = DataSplit(index + 1).toDouble
      accountPortfolio += sAccount}
    if(DataSplit.contains("Help to buy ISA")) {
      var index = DataSplit.indexOf("Help to buy ISA")
      var IAccount = new HelpToBuyISA("Help to buy ISA")
      IAccount.AccountBalance = DataSplit(index + 1).toDouble
      accountPortfolio += IAccount}
    if(DataSplit.contains("Credit Account")){var cAccount = new CreditAccount("Credit Account", true)
      accountPortfolio += cAccount
      if(DataSplit.contains("Rewards credit card")){
        var index = DataSplit.indexOf("Rewards credit card")
        var RewardsCard = new CreditCard(DataSplit(index + 1).toDouble, "Rewards credit card", DataSplit(index + 2).toDouble, DataSplit(index + 3).toInt)
        cAccount.creditCards += RewardsCard}
      if(DataSplit.contains("Basic credit card")){
        var index = DataSplit.indexOf("Basic credit card")
        var basicCard = new CreditCard(DataSplit(index + 1).toDouble, "Basic credit card", DataSplit(index + 2).toDouble, DataSplit(index + 3).toInt)
        cAccount.creditCards += basicCard}
      if(DataSplit.contains("Balance transfer card")){
        var index = DataSplit.indexOf("Balance transfer card")
        var BalanceTransferCard = new CreditCard(DataSplit(index + 1).toDouble, "Balance transfer card", DataSplit(index + 2).toDouble, DataSplit(index + 3).toInt)
        cAccount.creditCards += BalanceTransferCard}
    }
}

  def showAccounts(): Unit = {
    println("You currently have: ")
    for(account <- accountPortfolio) {
      if(account.AccountType != "Credit Account") {
        println(account.AccountType + " => Balance of £" + account.AccountBalance)
      }
      else {
        account.showCurrentCards()
      }
    }
    println("")
  }

  @throws(classOf[TooManyAccountExceptions])
  def openAccount(): Unit = {
    println("What type of account would you like to open?\n1.Savings\n2.Credit\n3.Lifetime ISA")
    var accountType = scala.io.StdIn.readInt()
    accountType match {
      case 1 => if(!tooManyAccountsCheck("Savings Account")){
        var sAccount = new SavingsAccount("Savings Account")
        accountPortfolio += sAccount
        println("A new savings account has been created\n")}
      case 2 => if(!tooManyAccountsCheck("Credit Account")){
        var cAccount = new CreditAccount("Credit Account", true)
        accountPortfolio += cAccount
        println("A new credit account has been created\n")}
      case 3 => if(!tooManyAccountsCheck("Help to buy ISA")){
        var IAccount = new HelpToBuyISA("Help to buy ISA")
        accountPortfolio += IAccount
        println("A new ISA account has been created\n")}
    }
  }

  def showAccountDetails(): Unit = {
    var selected_account:Int = accountSelection()
    if(accountPortfolio(selected_account).AccountType != "Credit Account"){
    println("The current balance of your "+accountPortfolio(selected_account).AccountType+" is £"+accountPortfolio(selected_account).AccountBalance)}
    else{
        println(accountPortfolio(selected_account).showCurrentCards())
    }
  }

  @throws(classOf[TooManyAccountExceptions])
  def tooManyAccountsCheck(s: String):Boolean = {
    var AccountTotal: Map[String, Int] = Map()
    for (account <- accountPortfolio) {
      AccountTotal += (account.AccountType -> 1)
    }
    try {
      if (AccountTotal.contains(s)) {
        throw new TooManyAccountExceptions("You already have an account of this type.")
      }
      else{
        return false
      }
    }
    catch {
      case exp: TooManyAccountExceptions => println(exp)
    }
    true
  }

  def accountSelection():Int = {
    println("Which account would you like to select?: ")
    //For loop that prints the accounts owned in a numbered format
    //Hence why they are zipped with their indexes
    for ((account, index) <- accountPortfolio.zipWithIndex) print((index + 1) + ". " + account.AccountType+"\n")
    var accountDetails = scala.io.StdIn.readInt()
    accountDetails match {
      //We need to return one less then their choice because we are working working indexes starting from zero
      case 1 => 0
      case 2 => 1
      case 3 => 2
      case 4 => 3
    }
  }

  def accountOptions():Unit = {
    var selected_account = accountSelection()
    if(accountPortfolio(selected_account).AccountType == "Credit Account"){
      println("Your account options are:\n1. Withdraw from a credit card\n2. Deposit\n3. Transfer\n4. Order a new credit card\n5. Show current credit cards\n6. Pay off a credit card")
    }
    else {
      println("Your account options are:\n1. Withdraw\n2. Deposit\n3. Transfer")
    }
    var accountOptionChosen = scala.io.StdIn.readInt()
    accountOptionChosen match {
      case 1 => if(accountPortfolio(selected_account).AccountType == "Credit Account"){
        accountPortfolio(selected_account).withdrawFromCreditCards()
      }
      else{
        accountPortfolio(selected_account).withdrawMoney()
      }
      case 2 => accountPortfolio(selected_account).depositMoney()
      case 3 => transferMoney(accountPortfolio(selected_account))
      case 4 => accountPortfolio(selected_account).orderNewCreditCard()
      case 5 => accountPortfolio(selected_account).showCurrentCards()
      case 6 => println("Which credit card would you like to pay off? ")
        if (accountPortfolio(selected_account).creditCards.nonEmpty) {
          for ((card, index) <- accountPortfolio(selected_account).creditCards.zipWithIndex) println(index + 1 + ". " + card.cardType + " => Balance of £" + card.ccBalance)
        }
        else {
          println("You do not have any active credit cards")
        }
        var chosenCard = scala.io.StdIn.readInt()
      accountPortfolio(selected_account).creditCards(chosenCard - 1).payCreditCard(accountPortfolio, accountPortfolio(selected_account))

    }
  }

  def transferMoney(current_selected_account:Account): Unit = {
    println("Which account would you like to transfer money to? ")
    for ((account, index) <- accountPortfolio.zipWithIndex) print((index + 1) + ". " + account.AccountType + "\n")
    var selection = scala.io.StdIn.readInt() - 1
    if (accountPortfolio(selection).AccountType != current_selected_account.AccountType) {
      println("How much would you like to transfer?")
      var transferalAmount = scala.io.StdIn.readDouble()
      if (transferalAmount < current_selected_account.AccountBalance) {
        current_selected_account.AccountBalance -= transferalAmount
        accountPortfolio(selection).AccountBalance += transferalAmount
        //Show the user the new balances of the accounts
        println("The new balance of " + current_selected_account.AccountType + " is £" + current_selected_account.AccountBalance)
        println("The new balance of " + accountPortfolio(selection).AccountType + "is £" + accountPortfolio(selection).AccountBalance)
      }

    }
    else {
      println("Please pick an account other than the current selected one")
      transferMoney(current_selected_account)
    }
  }
}