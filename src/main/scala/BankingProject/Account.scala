package BankingProject

import com.wiley.CaseClass.Car
import scala.collection.mutable.ListBuffer

//Custom exception invoked when the user attempts to
//withdraw money that they don't have
class NotEnoughFundsException(s:String) extends Exception {
  override def toString: String = super.toString + "-" + s
}

//Abstract class Account used as a skeleton for each of the
//unique bank accounts (Savings, Credit, etc)
//Each account has a balance and monetary functions
abstract class Account(val AccountType:String = ""){
  var AccountBalance: Double = 0.0

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
  def showCurrentCards():Unit = {}
}

//Case class for current account extending the Account class, the account type is overriden here
case class CurrentAccount(override val AccountType:String) extends Account
//Case class for savings account extending the Account class, the account type is overriden here
case class SavingsAccount(override val AccountType:String) extends Account
//Case class for help to buy ISA account extending the Account class, the account type is overriden here
case class HelpToBuyISA(override val AccountType:String) extends Account

//Child class of abstract class Account that inherits all it's attributes and methods
class CreditAccount(override val AccountType:String) extends Account {
  //ListBuffer container storing our portfolio of credit cards
  var creditCards = new ListBuffer[CreditCard]()

  //overriden abstract method from Account Class
  //Used for ordering a new credit card
  override def orderNewCreditCard(): Unit = {
    //Display and choose credit card options
    println("Which credit card would you like to apply for?\n1. Basic credit card\n2. Rewards credit card\n3. Balance transfer credit card")
    var cardSelection = scala.io.StdIn.readInt()
    cardSelection match {
      //Pattern matching triggered based on user input
      //Each case ends with a success message
      //Create new basic credit card object with attributes pre-defined
      //Add it to the credit card portfolio
      case 1 => var basicCard = new CreditCard(2000, "Basic credit card", 2000, 16)
        creditCards += basicCard
        println(f"You have successfully applied for a new Basic credit card, this card has a credit limit of £${basicCard.creditLimit} and an interest rate of %%${basicCard.interestRate} ")
      //Create new rewards credit card object with attributes pre-defined
      //Add it to the credit card portfolio
      case 2 => var RewardsCard = new CreditCard(2000, "Rewards credit card", 2000, 20)
        creditCards += RewardsCard
        println(f"You have successfully applied for a new Rewards credit card, this card has a credit limit of £${RewardsCard.creditLimit} and an interest rate of %%${RewardsCard.interestRate} ")
      //Create new balance transfer credit card object with attributes pre-defined
      //Add it to the credit card portfolio
      case 3 => var BalanceTransferCard = new CreditCard(1000, "Balance transfer card", 1000, 1)
        creditCards += BalanceTransferCard
        println(f"You have successfully applied for a new Basic credit card, this card has a credit limit of £${BalanceTransferCard.creditLimit} and an interest rate of %%${BalanceTransferCard.interestRate} ")
    }
  }

  //overriden abstract method from Account Class
  //Responsible for display the users credit card portfolio
  override def showCurrentCards(): Unit = {
    //If the customer has no credit cards, let him know
    //Otherwise, show the card types and balances
    if (creditCards.nonEmpty) for (card <- creditCards) println(card.cardType + " => Balance of £" + card.ccBalance)
    else println("You do not have any active credit cards")
  }
}

//Class created to create credit card objects
//Has multiple default attributes
class CreditCard(var ccBalance:Double = 0.0,var cardType:String = "",var creditLimit:Double = 0.0,var interestRate:Int = 0){
  //Unfinished method used to pay back credit card debt
  def payCreditCard():Unit = {
  }
}






