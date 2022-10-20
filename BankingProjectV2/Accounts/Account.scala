package BankingProjectV2.Accounts

import BankingProjectV2.CreditCard.CreditCard
import com.wiley.Exceptions.NotEnoughFundsException

import BankingProjectV2.validateInput.validateInput.isDigits
import scala.collection.mutable.ListBuffer


//Abstract class account used as the skeleton for all other accounts
//Instantiated when a new accountType is created
abstract class Account(val AccountType:String = "") {
  //All accounts have a balance, only the credit account has a credit card portfolio
  var AccountBalance: Double = 0.00
  var creditCards = new ListBuffer[CreditCard]()

  //Method responsible for depositing money into an account
  def depositMoney(): Unit = {
    println("Please enter the amount of cash you would like to deposit: ")
    var depositAmount = scala.io.StdIn.readDouble()
    //Add the user input into the corresponding account
    AccountBalance += depositAmount
    //Updated balance output
    println(f"You have deposited successfully!\nYour new balance is £$AccountBalance%1.2f\n")
  }

  //Method responsible for withdrawing money from all accounts except for Credit account
  def withdrawMoney(): Unit = {
    println(f"You're current balance is £$AccountBalance%1.2f")
    println("Please enter the amount of cash you would like to withdraw: ")
      var withdrawalAmount = scala.io.StdIn.readDouble()
    //Try block to validate that the user can cover the amount of money they are trying to
    //withdraw with their current balance
      try {
        if (withdrawalAmount > AccountBalance) {
          //If they don't have enough, throw the custom NotEnoughFundsException
          throw new NotEnoughFundsException("Unfortunately, you don't have enough money")
        }
      }
      catch {
            //Catch the thrown exception, print the output, and call the method again so the
            //User can input a valid amount to withdraw
        case exp: NotEnoughFundsException => println(exp)
          withdrawMoney()
      }
      //User is required to stipulate what notes they would like to withdraw
      println("Please enter the notes which you would like in the form: x,x,x")
      var withdrawalFormat = scala.io.StdIn.readLine()
      //Split the input using a comma as the delimiter
      var Notes = withdrawalFormat.split(",")
      var Total = 0
      Notes.foreach(Total += _.toInt)
      //If the user hasn't chosen enough notes for the withdrawal
      if (Total < withdrawalAmount) {
        println(f"You only gave $Total worth of notes for a withdrawal worth $withdrawalAmount")
      }
        //If the user has chosen too many notes for the withdrawal
      else if (Total > withdrawalAmount) {
        println(f"You cannot withdraw $Total worth of notes for a withdrawal worth $withdrawalAmount")
      }
      else {
        //If the user has chosen the correct amount of notes, subtract it from their current balance
        //Then print the new balance
        AccountBalance -= withdrawalAmount
        println(f"You have withdrawn $Total successfully\nYou're new balance is $AccountBalance%1.2f")
      }
  }

  //Abstract methods defined in the child class CreditAccount
  def orderNewCreditCard(): Unit = {}

  //Abstract methods defined in the child class CreditAccount
  def showCurrentCards(): Unit = {}

  //Abstract method defined in the child class CreditAccount
  def withdrawFromCreditCards():Unit = {}
}
