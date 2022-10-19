package BankingProjectV2.Navigation
import BankingProjectV2.Exceptions.{ExistingAccountException, TooManyAccountExceptions}
import BankingProjectV2.Profile.Profile
import BankingProjectV2.SQL_Account_Storage.{DoesAccountExist, LoadAccount, UpdateAccount}
import scala.collection.mutable.{ArrayStack, ListBuffer}


object Login extends App {
  var Exit = false
  do {
    println("How can we help you today?\n1. Login to existing account\n2. Create new account\n3. Exit")
    var Entry = scala.io.StdIn.readInt()
    Entry match {
      case 1 => LoginProcedure()
      case 2 => CreateAccount()
      case 3 => Exit = true
    }
  }
  while (!Exit)

  @throws(classOf[ExistingAccountException])
  def CreateAccount(): Unit = {
    //User inputs for the account credentials
    println("Please enter a username: ")
    val Username = scala.io.StdIn.readLine()
    println("Please enter a password: ")
    val Password = scala.io.StdIn.readLine()
    var Checker = new DoesAccountExist
    try {
      if (Checker.Check(Username, Password)) {
        throw new ExistingAccountException("An account already exists with these details! Please try again!")
      }
      else {
        val r = scala.util.Random
        var Random_Chars = for (i <- 0 to r.nextInt(10)) yield r.nextPrintableChar
        var Random_Ints = for (i <- 1 to 5) yield r.nextInt(100)
        var new_ID_Vector = Random_Chars.concat(Random_Ints)
        val new_ID = new_ID_Vector.mkString("")
        var user = new Profile(new_ID)
        reusableMenu(user, Username, Password, new_ID)
      }
    }
    catch {
      case exp: ExistingAccountException => println(exp)
      }
    CreateAccount()
    }

  def LoginProcedure(): Unit = {
    //User inputs for the accounts NEW credentials
    println("Please enter your username: ")
    var Username = scala.io.StdIn.readLine()
    println("Please enter your password: ")
    var Password = scala.io.StdIn.readLine()
    var AccountChecker = new DoesAccountExist
    if(AccountChecker.Check(Username, Password)) {

      var user = new LoadAccount()
      var LoadedAccountAndID = user.Load(Username, Password)
      reusableMenu(LoadedAccountAndID._1, Username, Password, LoadedAccountAndID._2)
    }
    else{
      println("Sorry this account does not exist, please try again!")
      LoginProcedure()
    }
  }


  def reusableMenu(obj: Profile, Username: String, Password: String, new_ID: String): Unit = {
    var Exit = false
    do {
      println("Here's a list of things that you can do:\n1. Show all open accounts\n2. Open a new account\n3. Select Account for usage\n4. Exit")
      var Entry = scala.io.StdIn.readInt()
      Entry match {
        case 1 => obj.showAccounts()
        case 2 => obj.openAccount()
        case 3 => obj.accountOptions()
        case 4 =>
          var DataStrings = ListBuffer[String]()
          var DataDoubles = ListBuffer[Double]()
          var DataBoolean = ListBuffer[Boolean]()
          var DataInt = ListBuffer[Int]()
          DataStrings += Username
          DataStrings += Password
          DataStrings += new_ID

          var CurrentAccount = obj.accountPortfolio.filter(_.AccountType == "Current Account")
          var savingsAccount = obj.accountPortfolio.filter(_.AccountType == "Savings Account")
          var ISA = obj.accountPortfolio.filter(_.AccountType == "Help to buy ISA")

          DataDoubles += CurrentAccount.head.AccountBalance

          var cAccount = obj.accountPortfolio.filter(_.AccountType == "Credit Account")
          if(cAccount.isEmpty){
            var emptyCase = List(false, false,0.0,"",0.0,0,false,0.0,"",0.0,0,false,0.0,"",0.0,0)
            for(element <- emptyCase){
              if(element == false){
                DataBoolean += false
              }
              if(element == 0.0){
                DataDoubles += 0.0
              }
              if(element == ""){
                DataStrings += ""
              }
              if(element == 0){
                DataInt += 0
              }
            }
          }
          else{
            DataBoolean += true
            var basicCard = cAccount.head.creditCards.filter(_.cardType == "Basic credit card")
            var rewardsCard = cAccount.head.creditCards.filter(_.cardType == "Rewards credit card")
            var balancetransfercard = cAccount.head.creditCards.filter(_.cardType == "Balance transfer card")

            var CardList = List(basicCard, rewardsCard, balancetransfercard)

            for(card <- CardList) {
              if(card.isEmpty){
                DataBoolean += false
                DataDoubles += 0.0
                DataStrings += ""
                DataDoubles += 0.0
                DataInt += 0
              }
              else{
                DataBoolean += true
                DataDoubles += card.head.ccBalance
                DataStrings += card.head.cardType
                DataDoubles += card.head.creditLimit
                DataInt += card.head.interestRate
              }
            }
          }

          var AccountList = List(savingsAccount, ISA)
          for (account <- AccountList) {
            if (account.isEmpty) {
              DataBoolean += false
              DataDoubles += 0.0
            }
            else {
              DataBoolean += true
              DataDoubles += account.head.AccountBalance
            }
          }

          var updateInstance = new UpdateAccount
          updateInstance.update(DataStrings, DataInt, DataDoubles, DataBoolean, Username, Password)
          println("See you next time! Goodbye.")
          System.exit(0)
      }
    }
    while (!Exit)
  }
}

