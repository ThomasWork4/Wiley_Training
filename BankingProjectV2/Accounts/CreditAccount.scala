package BankingProjectV2.Accounts

import BankingProjectV2.Accounts.Account
import BankingProjectV2.CreditCard.CreditCard
import BankingProjectV2.Exceptions.NotEnoughFundsException

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

//Child class of abstract class Account that inherits all it's attributes and methods
class CreditAccount(override val AccountType:String, var active:Boolean) extends Account {

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
      case 1 => var basicCard = new CreditCard(0, "Basic credit card", 2000, 16)
        creditCards += basicCard
        println(f"You have successfully applied for a new Basic credit card, this card has a credit limit of £${basicCard.creditLimit} and an interest rate of %%${basicCard.interestRate} ")
      //Create new rewards credit card object with attributes pre-defined
      //Add it to the credit card portfolio
      case 2 => var RewardsCard = new CreditCard(0, "Rewards credit card", 2000, 20)
        creditCards += RewardsCard
        println(f"You have successfully applied for a new Rewards credit card, this card has a credit limit of £${RewardsCard.creditLimit} and an interest rate of %%${RewardsCard.interestRate} ")
      //Create new balance transfer credit card object with attributes pre-defined
      //Add it to the credit card portfolio
      case 3 => var BalanceTransferCard = new CreditCard(0, "Balance transfer card", 1000, 1)
        creditCards += BalanceTransferCard
        println(f"You have successfully applied for a new Basic credit card, this card has a credit limit of £${BalanceTransferCard.creditLimit} and an interest rate of %%${BalanceTransferCard.interestRate} ")
    }
  }

  //overridden abstract method from Account Class
  //Responsible for display the users credit card portfolio
  override def showCurrentCards(): Unit = {
    //If the customer has no credit cards, let him know
    //Otherwise, show the card types and balances
    if(creditCards.nonEmpty) {
      for (card <- creditCards) println(card.cardType + " => Balance of £" + card.ccBalance)
    }
    else {
      println("You do not have any active credit cards")
    }
  }

  @throws(classOf[NotEnoughFundsException])
  override def withdrawFromCreditCards(): Unit = {
      if (creditCards.isEmpty) {
        println("You do not have any active credit cards")
        return
      }

      println("Which card would you like to withdraw from?")
      for ((card, index) <- creditCards.zipWithIndex) println(index+1+". "+card.cardType + " => Balance of £" + card.ccBalance)
      var chosenCard = scala.io.StdIn.readInt() - 1
      println("How much would you like to withdraw from this card?")
      var withdrawalAmount = scala.io.StdIn.readInt()
      try {
        if (withdrawalAmount > creditCards(chosenCard).creditLimit - creditCards(chosenCard).ccBalance.abs) {
          //If they don't have enough, throw the custom exception
          throw new NotEnoughFundsException("Unfortunately, you don't have enough money")
        }
      }
      catch {
        case exp: NotEnoughFundsException => println(exp)
          //Catch the custom exception and recall the function so they can enter a valid amount
          withdrawFromCreditCards()
      }
      //The customer should stipulate what notes that would like to withdraw
      println("Please enter the notes which you would like in the form: x,x,x")
      var withdrawalFormat = scala.io.StdIn.readLine()
      var Notes = withdrawalFormat.split(",")
      var Total = 0
      //The notes should equal the amount that they originally wanted to withdraw
      Notes.foreach(Total += _.toInt)
      if (Total < withdrawalAmount) {
        //They haven't chosen enough notes
        println(f"You only gave $Total worth of notes for a withdrawal worth $withdrawalAmount")
      }
      else if (Total > withdrawalAmount) {
        //They have asked for too many notes
        println(f"You cannot withdraw $Total worth of notes for a withdrawal worth $withdrawalAmount")
      }
      else {
        //Otherwise, decrease the balance and return a success message as well as the accounts
        //new balance
        creditCards(chosenCard).ccBalance -= withdrawalAmount
        println(f"You have withdrawn $Total successfully\nYou're new balance is £"+creditCards(chosenCard).ccBalance)
        println(f"You have £"+(creditCards(chosenCard).creditLimit - creditCards(chosenCard).ccBalance.abs)+" left to spend until you hit your credit limit")
      }
    }
}