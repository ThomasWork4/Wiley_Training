package BankingProjectV2.CreditCard

import BankingProjectV2.Accounts.{Account, CreditAccount}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

//Credit card class, initialized everytime a new credit card is requested
class CreditCard(var ccBalance:Double = 0.0,var cardType:String = "",var creditLimit:Double = 0.0,var interestRate:Int = 0){

  //Function responsible for paying of a credit card
  //The parameters it accepts are the users current account portfolio and their credit account
  def payCreditCard(accountPortfolio:ListBuffer[Account], cAccount: Account):Unit = {

    //Display the the options menu for possible account
    println("Which account would you like to use to pay off your credit card?")
    println("----------------------------------------------------------------")
    //Use a modified for loop to display each account in the portfolio
    //In a print statement
    for ((account, index) <- accountPortfolio.zipWithIndex) {
      if (account.AccountType != "Credit Account") {
        //Display the account name and balance
        println(index + 1 + f". ${account.AccountType} => Balance of £${account.AccountBalance}%1.2f")
      }
      else {
        //Make sure to indicate that the user cannot use a credit account to pay off credit cards
        println(index + 1 + ". Credit Account (Cannot be used to pay off credit cards)")
      }
    }
    println("----------------------------------------------------------------")
    println("Please enter the corresponding number: ")
    //Minus one from user input because options start from 1
    //Whereas indexes start from zero
    var chosenAccount = scala.io.StdIn.readInt() - 1
    //Display payment options
    println("1. Pay entire statement\n2. Pay custom amount")
    var option: Int = scala.io.StdIn.readInt()
    if (option == 1) {
      //If they want to pay the entire statement, deduct whatever the abs of the credit balance
      //is from the chosen account
      accountPortfolio(chosenAccount).AccountBalance - cAccount.creditCards(chosenAccount).ccBalance.abs
      //Reset the credit balance
      cAccount.creditCards(chosenAccount).ccBalance = 0
      //Display new account and card balanced after the transaction has taken place
      println(f"You're new ${cAccount.creditCards(chosenAccount).cardType} balance is £0.00")
      println(f"You're new ${accountPortfolio(chosenAccount).AccountBalance} balance is £${accountPortfolio(chosenAccount).AccountBalance}%1.2f")
    }
    if (option == 2) {
      //If they want to pay a custom amount, deduct the custom amount from the account balance
      println("How much would you like to transfer?")
      var amount:Int = scala.io.StdIn.readInt()
      accountPortfolio(chosenAccount).AccountBalance -= amount
      //Then add it to the current card balance
      cAccount.creditCards(chosenAccount).ccBalance += amount
      //Finally print the new account and card statuses with the new balances
      //before going back to the reusable menu
      println(f"You're new ${cAccount.creditCards(chosenAccount).cardType} balance is £${cAccount.creditCards(chosenAccount).ccBalance}%1.2f")
      println(f"You're new ${accountPortfolio(chosenAccount).AccountType} balance is £${accountPortfolio(chosenAccount).AccountBalance}%1.2f")
    }
  }
}