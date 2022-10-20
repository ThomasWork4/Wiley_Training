package BankingProjectV2.SQL_Account_Storage
import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.mutable.ListBuffer


class DoesAccountExist {
  //Utility function created for checking whether an account exists inside the SQL database
  //It's passed whatever the user has inputted for credentials
  def Check(Username:String, Password:String): Boolean = {
    val driver = "com.mysql.cj.jdbc.Driver"
    //URL for the accountStorage database
    val url = "jdbc:mysql://localhost:3306/accountStorage"
    //Username and password for mySQL server
    //TODO these need to change when testing the program from a different desktop
    val username = "root"
    val password = "alphamale123"

    //Creating a connection instance
    var connection: Connection = null

    //Try block for exception purposes
    try {
      Class.forName(driver)
      //Test the connection using the current username, password
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      //Select all usernames and passwords from the table
      val resultSet = statement.executeQuery("select Username,Password from accountStorage; ")
      //Iterate each username and password and check whether they are the same as the ones passed as a parameter to this function
      while (resultSet.next()) {
        val UsernameFromStorage = resultSet.getString("Username")
        val PasswordFromstorage = resultSet.getString("Password")
        //If they both are, then the account information exists in the database
        if (UsernameFromStorage == Username && PasswordFromstorage == Password){
          return true
        }
      }
      //Otherwise, return false, meaning the account information does not exist in the database
      false
    }
      //Catch all exceptions that may source from the SQL connection
    catch {
      case e: Exception => e.printStackTrace()
        false
    }
    finally {
      //Close the connection before displaying the exception and terminating the program
      connection.close()
    }
  }
}