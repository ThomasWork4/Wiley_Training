package BankingProjectV2.SQL_Account_Storage

import BankingProjectV2.Accounts.{CreditAccount, HelpToBuyISA, SavingsAccount}
import BankingProjectV2.CreditCard.CreditCard

import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.mutable.ListBuffer
import BankingProjectV2.Profile
import BankingProjectV2.Profile.Profile

import scala.util.control.Breaks.break

class LoadAccount() {
  //Function responsible for loading an accounts details from the SQL server
  //And loading them to a new profile object so as to simulate
  //A restore of the previous session
  def Load(CurrentUsername:String, CurrentPassword:String):(Profile, String) = {
    val driver = "com.mysql.cj.jdbc.Driver"
    //URL for the accountStorage database
    val url = "jdbc:mysql://localhost:3306/accountStorage"
    //Username and password for mySQL server
    //TODO these need to change when testing the program from a different desktop
    val username = "root"
    val password = "alphamale123"

    // connection instance creation
    var connection: Connection = null
    try {
      Class.forName(driver)
      //Test the connection using the current username, password
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      //Retrieve all the information from the database where the username and password matches the record
      val resultSet = statement.executeQuery("SELECT * FROM accountStorage WHERE Username = \""+CurrentUsername+"\" and Password = \"" + CurrentPassword+"\";")
      //Create a new empty profile
      var LoadedUser = new Profile()
      var ID: String = ""
      //Iterate the result set
      while (resultSet.next()) {
        //Restore the current account balance to the retrieved value from the database
        LoadedUser.accountPortfolio.head.AccountBalance = resultSet.getDouble("CurrentAccountBalance")
        ID = resultSet.getString("ID")
        //If the credit account field is false, we know they didn't have an account previously
        //Otherwise, create a new credit account
        if(resultSet.getBoolean("CreditAccount")){
          var cAccount = new CreditAccount("Credit Account", true)
          //If the user previously had a basic credit card
          //Restore all it's corresponding attributes to the values retrieved from the database
          if(resultSet.getBoolean("BasicCreditCard")){
            var basicCard = new CreditCard(resultSet.getDouble("BasicCreditCardBalance"), resultSet.getString("BasicCreditCardType"), resultSet.getDouble("BasicCreditCardLimit"), resultSet.getInt("BasicCreditCardIR"))
            cAccount.creditCards += basicCard
          }
          //If the user previously had a rewards credit card
          //Restore all it's corresponding attributes to the values retrieved from the database
          if(resultSet.getBoolean("RewardsCreditCard")){
            var RewardsCard = new CreditCard(resultSet.getDouble("RewardsCreditCardBalance"), resultSet.getString("RewardsCreditCardType"), resultSet.getDouble("RewardsCreditCardLimit"), resultSet.getInt("RewardsCreditCardIR"))
            cAccount.creditCards += RewardsCard
          }
          //If the user previously had a balance transfer credit card
          //Restore all it's corresponding attributes to the values retrieved from the database
          if(resultSet.getBoolean("BalanceTransferCard")){
            var BalanceTransferCard = new CreditCard(resultSet.getDouble("BalanceTransferCardBalance"), resultSet.getString("BalanceTransferCardType"), resultSet.getDouble("BalanceTransferCardLimit"), resultSet.getInt("BalanceTransferCardIR"))
            cAccount.creditCards += BalanceTransferCard
          }
          LoadedUser.accountPortfolio += cAccount
        }
        //If the user previously had a savings account
        //Restore all it's corresponding attributes to the values retrieved from the database
        if(resultSet.getBoolean("SavingsAccount")){
          var sAccount = new SavingsAccount("Savings Account")
          sAccount.AccountBalance = resultSet.getDouble("SavingsAccountBalance")
          LoadedUser.accountPortfolio += sAccount

        }
        //If the user previously had a help to buy ISA account
        //Restore all it's corresponding attributes to the values retrieved from the database
        if (resultSet.getBoolean("ISA")) {
          var IAccount = new HelpToBuyISA("Help to buy ISA")
          IAccount.AccountBalance = resultSet.getDouble("ISABalance")
          LoadedUser.accountPortfolio += IAccount
        }

      }
      //Return the users profile with all the updated attributes and variables, as well as the profile ID
      (LoadedUser, ID)
    }
      //Catch all exceptions that may source from the SQL connection
    catch {
      case e: Exception => e.printStackTrace()
        break

    }
      //Close the connection before displaying the exception and terminating the program
    finally {
      connection.close()
    }
  }
}