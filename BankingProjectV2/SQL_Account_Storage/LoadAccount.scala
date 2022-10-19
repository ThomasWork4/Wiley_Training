package BankingProjectV2.SQL_Account_Storage

import BankingProjectV2.Accounts.{CreditAccount, HelpToBuyISA, SavingsAccount}
import BankingProjectV2.CreditCard.CreditCard

import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.mutable.ListBuffer
import BankingProjectV2.Profile
import BankingProjectV2.Profile.Profile

import scala.util.control.Breaks.break

class LoadAccount() {
  def Load(CurrentUsername:String, CurrentPassword:String):(Profile, String) = {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/accountStorage"
    val username = "root"
    val password = "alphamale123"

    // connection instance creation
    var connection: Connection = null
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM accountStorage WHERE Username = \""+CurrentUsername+"\" and Password = \"" + CurrentPassword+"\";")
      var LoadedUser = new Profile()
      var ID: String = ""
      while (resultSet.next()) {
        LoadedUser.accountPortfolio.head.AccountBalance = resultSet.getDouble("CurrentAccountBalance")
        ID = resultSet.getString("ID")
        if(resultSet.getBoolean("CreditAccount")){
          var cAccount = new CreditAccount("Credit Account", true)
          if(resultSet.getBoolean("BasicCreditCard")){
            var basicCard = new CreditCard(resultSet.getDouble("BasicCreditCardBalance"), resultSet.getString("BasicCreditCardType"), resultSet.getDouble("BasicCreditCardLimit"), resultSet.getInt("BasicCreditCardIR"))
            cAccount.creditCards += basicCard
          }
          if(resultSet.getBoolean("RewardsCreditCard")){
            var RewardsCard = new CreditCard(resultSet.getDouble("RewardsCreditCardBalance"), resultSet.getString("RewardsCreditCardType"), resultSet.getDouble("RewardsCreditCardLimit"), resultSet.getInt("RewardsCreditCardIR"))
            cAccount.creditCards += RewardsCard
          }
          if(resultSet.getBoolean("BalanceTransferCard")){
            var BalanceTransferCard = new CreditCard(resultSet.getDouble("BalanceTransferCardBalance"), resultSet.getString("BalanceTransferCardType"), resultSet.getDouble("BalanceTransferCardLimit"), resultSet.getInt("BalanceTransferCardIR"))
            cAccount.creditCards += BalanceTransferCard
          }
          LoadedUser.accountPortfolio += cAccount
        }

        if(resultSet.getBoolean("SavingsAccount")){
          var sAccount = new SavingsAccount("Savings Account")
          sAccount.AccountBalance = resultSet.getDouble("SavingsAccountBalance")
          LoadedUser.accountPortfolio += sAccount

        }

        if (resultSet.getBoolean("ISA")) {
          var IAccount = new HelpToBuyISA("Help to buy ISA")
          IAccount.AccountBalance = resultSet.getDouble("ISABalance")
          LoadedUser.accountPortfolio += IAccount
        }

      }
      (LoadedUser, ID)
    }
    catch {
      case e: Exception => e.printStackTrace()
        break

    }
    finally {
      connection.close()
    }
  }
}