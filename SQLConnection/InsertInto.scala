package SQLConnection

import java.sql.{Connection, DriverManager, PreparedStatement}

object InsertInto extends App{

  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/movies"
  val username = "root"
  val password = "alphamale123"

  // connection instance creation
  var connection: Connection = null
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username,password)
    val insertstatement = "INSERT INTO movies (title,genre,director,release_year) values(?,?,?,?)"

    var preparedStatement:PreparedStatement = connection.prepareStatement(insertstatement)
    preparedStatement.setString(1, "Shutter Island")
    preparedStatement.setString(2, "Thriller")
    preparedStatement.setString(3, "Steven Spielberg")
    preparedStatement.setString(4, "2016")
    preparedStatement.execute()
    }
  catch {
    case e: Exception => e.printStackTrace()
  }
  finally {
    connection.close()
  }
}

