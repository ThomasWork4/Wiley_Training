package BankingProjectV2.SQL_Account_Storage
import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.mutable.ListBuffer

class DoesAccountExist {
  def Check(Username:String, Password:String): Boolean = {
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
      val resultSet = statement.executeQuery("select Username,Password from accountStorage; ")
      while (resultSet.next()) {
        val UsernameFromStorage = resultSet.getString("Username")
        val PasswordFromstorage = resultSet.getString("Password")
        if (UsernameFromStorage == Username && PasswordFromstorage == Password){
          return true
        }
      }
      false
    }
    catch {
      case e: Exception => e.printStackTrace()
        false
    }
    finally {
      connection.close()
    }
  }
}