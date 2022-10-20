package BankingProjectV2.SQL_Account_Storage

import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.mutable.ListBuffer
import BankingProjectV2.SQL_Account_Storage.DoesAccountExist

class UpdateAccount {
  //Function responsible for either updating an already existing account in the database
  //Or creating a new instance of the account in the databse if it doesn't already exists
  //It accepts all the lists we previously made storing all the information about an account before the program was exited
  def update(DataStrings:ListBuffer[String], DataInt:ListBuffer[Int], DataFloats:ListBuffer[Double], DataBoolean:ListBuffer[Boolean], currentUsername:String, currentPassword:String):Unit = {
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
      //If the account exists already, it means we need to UPDATE the stored data
      //Not submit new ones
      var Checker = new DoesAccountExist
      if (Checker.Check(currentUsername, currentPassword)) {
        //SQL statement for updating all column fields
        val updateStatement = "UPDATE accountStorage SET CurrentAccountBalance = ?,CreditAccount = ?,BasicCreditCard = ?,BasicCreditCardBalance = ?,BasicCreditCardType = ?,BasicCreditCardLimit = ?,BasicCreditCardIR = ?,RewardsCreditCard = ?,RewardsCreditCardBalance = ?,RewardsCreditCardType = ?,RewardsCreditCardLimit = ?,RewardsCreditCardIR = ?,BalanceTransferCard = ?,BalanceTransferCardBalance = ?,BalanceTransferCardType = ?,BalanceTransferCardLimit = ?,BalanceTransferCardIR = ?,SavingsAccount = ?,SavingsAccountBalance = ?,ISA = ?,ISABalance = ? WHERE Username = ? AND Password = ?"
        var preparedStatement: PreparedStatement = connection.prepareStatement(updateStatement)
        //Set each of the 23 different column fields to whatever the saved values are
        preparedStatement.setDouble(1, DataFloats.head)
        preparedStatement.setBoolean(2, DataBoolean.head)
        preparedStatement.setBoolean(3, DataBoolean(1))
        preparedStatement.setDouble(4, DataFloats(1))
        preparedStatement.setString(5, DataStrings(3))
        preparedStatement.setDouble(6, DataFloats(2))
        preparedStatement.setInt(7, DataInt.head)
        preparedStatement.setBoolean(8, DataBoolean(2))
        preparedStatement.setDouble(9, DataFloats(3))
        preparedStatement.setString(10, DataStrings(4))
        preparedStatement.setDouble(11, DataFloats(4))
        preparedStatement.setInt(12, DataInt(1))
        preparedStatement.setBoolean(13, DataBoolean(3))
        preparedStatement.setDouble(14, DataFloats(5))
        preparedStatement.setString(15, DataStrings(5))
        preparedStatement.setDouble(16, DataFloats(6))
        preparedStatement.setInt(17, DataInt(2))
        preparedStatement.setBoolean(18, DataBoolean(4))
        preparedStatement.setDouble(19, DataFloats(7))
        preparedStatement.setBoolean(20, DataBoolean(5))
        preparedStatement.setDouble(21, DataFloats(8))
        preparedStatement.setString(22, currentUsername)
        preparedStatement.setString(23, currentPassword)
        //execute the SQL statement
        preparedStatement.execute()
      }
        //If the account doesn't exist in the database, then this is the first time a user has logged in and we need to make a new instance
        //in the database for that account
      else {
        //SQL statement for inserting a new entry into the table
        val insertstatement = "INSERT INTO accountStorage (Username,Password,ID,CurrentAccountBalance,CreditAccount,BasicCreditCard,BasicCreditCardBalance,BasicCreditCardType,BasicCreditCardLimit,BasicCreditCardIR,RewardsCreditCard,RewardsCreditCardBalance,RewardsCreditCardType,RewardsCreditCardLimit,RewardsCreditCardIR,BalanceTransferCard,BalanceTransferCardBalance,BalanceTransferCardType,BalanceTransferCardLimit,BalanceTransferCardIR,SavingsAccount,SavingsAccountBalance,ISA,ISABalance) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
        var preparedStatement: PreparedStatement = connection.prepareStatement(insertstatement)
        //Set each of the 23 different column fields to whatever the saved values are
        preparedStatement.setString(1, DataStrings.head)
        preparedStatement.setString(2, DataStrings(1))
        preparedStatement.setString(3, DataStrings(2))
        preparedStatement.setDouble(4, DataFloats.head)
        preparedStatement.setBoolean(5, DataBoolean.head)
        preparedStatement.setBoolean(6, DataBoolean(1))
        preparedStatement.setDouble(7, DataFloats(1))
        preparedStatement.setString(8, DataStrings(3))
        preparedStatement.setDouble(9, DataFloats(2))
        preparedStatement.setInt(10, DataInt.head)
        preparedStatement.setBoolean(11, DataBoolean(2))
        preparedStatement.setDouble(12, DataFloats(3))
        preparedStatement.setString(13, DataStrings(4))
        preparedStatement.setDouble(14, DataFloats(4))
        preparedStatement.setInt(15, DataInt(1))
        preparedStatement.setBoolean(16, DataBoolean(3))
        preparedStatement.setDouble(17, DataFloats(5))
        preparedStatement.setString(18, DataStrings(5))
        preparedStatement.setDouble(19, DataFloats(6))
        preparedStatement.setInt(20, DataInt(2))
        preparedStatement.setBoolean(21, DataBoolean(4))
        preparedStatement.setDouble(22, DataFloats(7))
        preparedStatement.setBoolean(23, DataBoolean(5))
        preparedStatement.setDouble(24, DataFloats(8))
        //execute the SQL statement
        preparedStatement.execute()
      }
    }
      //Catch all exceptions that may source from the SQL connection
    catch {
      case e: Exception => e.printStackTrace()
    }
    finally {
      //Close the connection before displaying the exception and terminating the program
      connection.close()
    }
  }
}



