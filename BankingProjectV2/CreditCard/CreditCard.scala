package BankingProjectV2.CreditCard

import BankingProjectV2.Accounts.{Account, CreditAccount}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

//Class created to create credit card objects
//Has multiple default attributes
class CreditCard(var ccBalance:Double = 0.0,var cardType:String = "",var creditLimit:Double = 0.0,var interestRate:Int = 0){
  //Unfinished method used to pay back credit card debt


  def payCreditCard(accountPortfolio:ListBuffer[Account], cAccount: Account):Unit = {
    println("Which account would you like to use to pay off your credit card?")
    for ((account, index) <- accountPortfolio.zipWithIndex) {
      if (account.AccountType != "Credit Account") {
        println(index + 1 + ". " + account.AccountType + " => Balance of £" + account.AccountBalance)
      }
      else {
        println(index + 1 + ". Credit Account (Cannot be used to pay off credit cards)")
      }
    }
    var chosenAccount = scala.io.StdIn.readInt() - 1
    println("1. Pay entire statement\n2. Pay custom amount")
    var option: Int = scala.io.StdIn.readInt()
    if (option == 1) {
      accountPortfolio(option).AccountBalance - cAccount.creditCards(chosenAccount).ccBalance.abs
      cAccount.creditCards(chosenAccount).ccBalance = 0
      println("You're new "+cAccount.creditCards(chosenAccount).cardType+" balance is £0.00")
      println("You're new "+accountPortfolio(chosenAccount).AccountBalance+" balance is £"+accountPortfolio(chosenAccount).AccountBalance)
    }
    if (option == 2) {
      println("How much would you like to transfer?")
      var amount:Int = scala.io.StdIn.readInt()
      accountPortfolio(chosenAccount).AccountBalance -= amount
      cAccount.creditCards(chosenAccount).ccBalance += amount
      println("You're new " + cAccount.creditCards(chosenAccount).cardType + " balance is £"+cAccount.creditCards(chosenAccount).ccBalance)
      println("You're new " + accountPortfolio(chosenAccount).AccountType + " balance is £" + accountPortfolio(chosenAccount).AccountBalance)
    }
  }
}