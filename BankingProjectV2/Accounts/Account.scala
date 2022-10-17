package BankingProjectV2.Accounts

import BankingProjectV2.CreditCard.CreditCard
import com.wiley.Exceptions.NotEnoughFundsException

import scala.collection.mutable.ListBuffer

//Abstract class Account used as a skeleton for each of the
//unique bank accounts (Savings, Credit, etc)
//Each account has a balance and monetary functions
abstract class Account(val AccountType:String = ""){
  var AccountBalance: Double = 0.0
  var creditCards = new ListBuffer[CreditCard]()

  //Function for depositing money into an account
  def depositMoney():Unit = {
    println("Please enter the amount of cash you would like to deposit: ")
    var depositAmount = scala.io.StdIn.readDouble()
    //Add the stipulated amount to the account balance and print the new balance
    AccountBalance += depositAmount
    println(f"You have deposited successfully!\nYour new balance is £$AccountBalance\n")
  }

  //Function for withdrawing money from an account
  @throws(classOf[NotEnoughFundsException])
  def withdrawMoney():Unit = {
    println("You're current balance is £"+AccountBalance)
    println("Please enter the amount of cash you would like to withdraw: ")
    var withdrawalAmount = scala.io.StdIn.readInt()
    //try block for checking whether the customer has enough funds to withdraw
    //with regards to how much they entered in the user input
    try{
      if(withdrawalAmount > AccountBalance){
        //If they don't have enough, throw the custom exception
        throw new NotEnoughFundsException("Unfortunately, you don't have enough money")
      }
    }
    catch{
      case exp:NotEnoughFundsException => println(exp)
        //Catch the custom exception and recall the function so they can enter a valid amount
        withdrawMoney()
    }
    //The customer should stipulate what notes that would like to withdraw
    println("Please enter the notes which you would like in the form: x,x,x")
    var withdrawalFormat = scala.io.StdIn.readLine()
    var Notes = withdrawalFormat.split(",")
    var Total = 0
    //The notes should equal the amount that they originally wanted to withdraw
    Notes.foreach(Total += _.toInt)
    if(Total < withdrawalAmount){
      //They haven't chosen enough notes
      println(f"You only gave $Total worth of notes for a withdrawal worth $withdrawalAmount")
    }
    else if(Total > withdrawalAmount){
      //They have asked for too many notes
      println(f"You cannot withdraw $Total worth of notes for a withdrawal worth $withdrawalAmount")
    }
    else{
      //Otherwise, decrease the balance and return a success message as well as the accounts
      //new balance
      AccountBalance -= withdrawalAmount
      println(f"You have withdrawn $Total successfully\nYou're new balance is $AccountBalance")
    }
  }

  //Abstract methods defined in the child class CreditAccount
  def orderNewCreditCard(): Unit = {}

  //Abstract methods defined in the child class CreditAccount
  def showCurrentCards(): Unit = {}

  def withdrawFromCreditCards():Unit = {}
}
